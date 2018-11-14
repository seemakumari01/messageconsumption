package com.messageconsumption.rest.security.token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.messageconsumption.rest.request.LoginUserDTO;

import java.util.Date;

/**
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecuredAccessToken extends Token {

    public SecuredAccessToken(@JsonProperty("currentLoggedInUser") LoginUserDTO currentLoggedInUser, @JsonProperty("createdDate") Date createdDate, @JsonProperty("expiryTime") Date expiryTime) {
        super(currentLoggedInUser, createdDate, expiryTime);
    }
}