package com.messageconsumption.service;


import com.messageconsumption.db.model.IdentityModel;
import com.messageconsumption.db.repositories.Repository;

import java.util.List;

/**
 * Service interface
 * @author Seema
 */
public interface Service<E extends IdentityModel, R extends Repository<E>> {

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
     * @return : boolean
     */
    boolean isPresent(String column, String value);

}
