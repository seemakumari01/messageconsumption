package com.messageconsumption.db.repositories;


import com.messageconsumption.db.model.User;

/**
 * @author Seema
 */
public interface UserRepository extends Repository<User> {
    User findByEmail(String email);

    /**
     * @param employeeCode : employeeCode
     * @return Boolean
     */
    Boolean isEmployeeCodeAndNumberExist(String employeeCode, String employeeName);

    /**
     * @return user
     */
    User findLastId();
}
