package com.messageconsumption.db.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeStampAbleModel extends DeleteAbleModel {

    private Long createdDate;

    private Long updatedDate;

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }


}
