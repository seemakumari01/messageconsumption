package com.messageconsumption.db.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.io.Serializable;

/**
 * Identity model for id
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityModel implements Serializable {

    @MongoId
    @MongoObjectId
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
