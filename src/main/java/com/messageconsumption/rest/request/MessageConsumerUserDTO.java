package com.messageconsumption.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageConsumerUserDTO {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
