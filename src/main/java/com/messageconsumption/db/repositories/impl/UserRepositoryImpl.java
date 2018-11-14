package com.messageconsumption.db.repositories.impl;

import com.google.common.collect.Lists;
import com.messageconsumption.db.model.User;
import com.messageconsumption.db.repositories.UserRepository;
import com.messageconsumption.exceptions.DatabaseOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;


/**
 * UserRepositoryImpl class
 * @author Seema
 */
@Repository

public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

    private static final Logger LOGGER = LogManager.getLogger(UserRepositoryImpl.class);

    @Autowired
    private Jongo jongo;

    private MongoCollection mongoCollection;

    @Override
    public User findByEmail(String email) {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            return (User) mongoCollection.findOne("{email:#,isDeleted:#}", email, Boolean.FALSE).as(getEntityClass());
        } catch(Exception e) {
            LOGGER.error("Error when user login time check username is exist :{}", e);
            throw new DatabaseOperationException(e.getMessage(), e);
        }
    }

    @Override
    public Boolean isEmployeeCodeAndNumberExist(String employeeCode, String employeeNumber) {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            return mongoCollection.findOne("{employeeCode:#,employeeNumber:#}", employeeCode, employeeNumber).as(entityClass) == null ? Boolean.FALSE : Boolean.TRUE;
        } catch(Exception e) {
            LOGGER.error("Error when user login time check username is exist :{}", e);
        }
        return null;
    }

    //Todo:need to do changes
    @Override
    public User findLastId() {
        mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
        Iterable<User> user = (Iterable<User>) mongoCollection.find("{isDeleted:#}", Boolean.FALSE).sort("{_id}:-1").limit(1);
        User u = new User();
        u = !Objects.isNull(Lists.newArrayList(user)) && !Lists.newArrayList(user).isEmpty() ? Lists.newArrayList(user).get(0) : null;
        return u;
    }
}
