package com.messageconsumption.db.repositories.impl;

import com.google.common.collect.Lists;
import com.messageconsumption.db.model.DeleteAbleModel;
import com.messageconsumption.db.model.IdentityModel;
import com.messageconsumption.db.model.TimeStampAbleModel;
import com.messageconsumption.db.repositories.Repository;
import com.messageconsumption.exceptions.DatabaseOperationException;
import com.messageconsumption.exceptions.InitializationException;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;


/**
 * BaseRepository Class
 *
 * @param <E>
 * @author Seema
 */

public class BaseRepository<E extends IdentityModel> implements Repository<E> {

    @Autowired
    private Jongo jongo;

    private MongoCollection mongoCollection;

    Class<E> entityClass;

    public BaseRepository() {
        try {
            Type t = getClass().getGenericSuperclass();
            ParameterizedType pt = (ParameterizedType) t;
            entityClass = (Class) pt.getActualTypeArguments()[0];
        } catch(Exception e) {
            throw new InitializationException("Base Repository class constructor in get GenericTypeParameter inside class name ", e);
        }
    }

    @Override
    public Class<?> getEntityClass() {
        try {
            return entityClass.newInstance().getClass();
        } catch(Exception e) {
            throw new DatabaseOperationException(e.getMessage(), e);
        }

    }

    @Override
    public E findById(String id) {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            return (E) mongoCollection.findOne("{_id:#,isDeleted:#}", new ObjectId(id), Boolean.FALSE).as(entityClass);
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<E> findAll() {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            Iterable<E> items = mongoCollection.find("{isDeleted:#}", Boolean.FALSE).as(entityClass);
            return Lists.newArrayList(items);
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<E> findAllBy(String column, String value) {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            Iterable<E> items = (Iterable<E>) mongoCollection.find("{" + column + ":#,isDeleted:#}", value, Boolean.FALSE).as(getEntityClass());
            return Lists.newArrayList(items);
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<E> findAllByOffset(int from, int to) {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());

            Iterable<E> items = (Iterable<E>) mongoCollection.find("{isDeleted:#}", Boolean.FALSE).skip(from).limit(to).as(getEntityClass());

            return Lists.newArrayList(items);
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
    }

    @Override
    public E findOneBy(String column, String value) {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            return (E) mongoCollection.findOne("{" + column + ":#,isDeleted:#}", value, Boolean.FALSE).as(getEntityClass());
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
    }

    @Override
    public void delete(E e) {
        try {
            if(e instanceof TimeStampAbleModel) {
                DeleteAbleModel t = (DeleteAbleModel) e;
                t.setDeleted(Boolean.TRUE);
                this.update(e);
            } else {
                mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
                mongoCollection.remove();

            }
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
    }

    @Override
    public int delete(String id) {
        try {
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            mongoCollection.update("{_id: #}", new ObjectId(id)).with("{$set: {isDeleted: #}}", Boolean.TRUE);
            return 0;

        } catch(Exception e) {
            throw new DatabaseOperationException(e.getMessage(), e);
        }
    }

    @Override
    public E save(E e) {
        try {
            if(e instanceof TimeStampAbleModel) {
                TimeStampAbleModel t = (TimeStampAbleModel) e;
                t.setCreatedDate(new DateTime().getMillis());
            }
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            mongoCollection.save(e);
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
        return e;
    }

    @Override
    public E update(E e) {
        try {
            if(e instanceof TimeStampAbleModel) {
                TimeStampAbleModel t = (TimeStampAbleModel) e;
                t.setUpdatedDate(new DateTime().getMillis());
            }
            mongoCollection = jongo.getCollection(getEntityClass().getSimpleName().toLowerCase());
            mongoCollection.save(e);
            return e;
        } catch(Exception ex) {
            throw new DatabaseOperationException(ex.getMessage(), ex);
        }
    }

    @Override
    public boolean isPresent(String column, String value) {
        mongoCollection = jongo.getCollection(entityClass.getSimpleName().toLowerCase());
        return Objects.nonNull(mongoCollection.findOne("{" + column + ":#,isDeleted:#}", value, Boolean.FALSE).as(getEntityClass())) ? Boolean.TRUE : Boolean.FALSE;
    }


}
