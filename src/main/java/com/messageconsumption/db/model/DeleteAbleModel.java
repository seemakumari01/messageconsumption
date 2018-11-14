package com.messageconsumption.db.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteAbleModel extends IdentityModel {

    private boolean isDeleted = Boolean.FALSE;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
