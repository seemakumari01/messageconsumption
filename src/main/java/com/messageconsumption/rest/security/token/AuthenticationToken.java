package com.messageconsumption.rest.security.token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/***
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationToken {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
