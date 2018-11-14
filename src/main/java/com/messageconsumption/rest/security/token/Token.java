package com.messageconsumption.rest.security.token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.messageconsumption.rest.request.LoginUserDTO;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Token {

    private LoginUserDTO currentLoggedInUser;


    private Date createdDate;


    private Date expiryTime;

    public Token(LoginUserDTO currentLoggedInUser, Date createdDate, Date expiryTime) {
        this.currentLoggedInUser = currentLoggedInUser;
        this.createdDate = createdDate;
        this.expiryTime = expiryTime;
    }

    public LoginUserDTO getCurrentLoggedInUser() {
        return currentLoggedInUser;
    }

    public void setCurrentLoggedInUser(LoginUserDTO currentLoggedInUser) {
        this.currentLoggedInUser = currentLoggedInUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }
}

