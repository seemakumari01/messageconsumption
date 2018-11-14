package com.messageconsumption.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.messageconsumption.db.model.IdentityModel;

import javax.validation.constraints.NotEmpty;

/**
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUserDTO extends IdentityModel {

    @NotEmpty(message = "password must not be empty")
    private String password;

    @NotEmpty(message = "email must not be empty")
    private String email;

    private String firstName;
    private String lastName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
