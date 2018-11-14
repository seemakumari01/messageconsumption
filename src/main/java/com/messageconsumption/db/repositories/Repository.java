package com.messageconsumption.db.repositories;

import com.messageconsumption.db.model.IdentityModel;

import java.io.Serializable;
import java.util.List;

/**
 * @param <E>
 * @author Seema
 */
public interface Repository<E extends IdentityModel> extends Serializable {

    /**
     * Get table name for generic entity
     *
     * @return String
     */
    Class<?> getEntityClass();

    /**
     * Find by id
     *
     * @param id Primary key for entity
     * @return Reference of type E
     */
    E findById(String id);

    /**
     * Get all records
     *
     * @return List of E
     */
    List<E> findAll();


    /**
     * Get list of rows by column and value
     *
     * @param column column name
     * @param value  column value
     * @return List<E> : Reference Type List
     */
    List<E> findAllBy(String column, String value);

    List<E> findAllByOffset(int from, int to);


    /**
     * Find by value
     *
     * @param column : String
     * @param value  : String
     * @return Reference of type E
     */
    E findOneBy(String column, String value);

    /**
     * Delete by object
     *
     * @param object E
     */
    void delete(E object);

    /**
     * Delete by primary key
     *
     * @param id Primary key of E
     */
    int delete(String id);

    /**
     * Persist entity into DB
     *
     * @param e Entity<extends IdentityModel>
     */
    E save(E e);

    /**
     * Updates entity into DB
     *
     * @param e Entity<extends IdentityModel>
     */
    E update(E e);

    /**
     * @param column : column
     * @param value  : value
     * @return : true or false
     */
    boolean isPresent(String column, String value);
}
