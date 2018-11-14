package com.messageconsumption.db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * User Class
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends TimeStampAbleModel {
    private String employeeNumber;

    private String employeeCode;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String phoneNumber;

    private String role;

    private String Address1;

    private String Address2;

    private String landmark;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private List<String> permission = null;
    /**
     * Getter
     * @return email
     */

    /**
     * Getter
     *
     * @return : employeeNumber
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Setter
     *
     * @param employeeNumber : employeeNumber
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Getter
     *
     * @return : employeeCode
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * Setter
     *
     * @param employeeCode : employeeCode
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Setter
     *
     * @param email : email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter
     *
     * @return First Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter
     *
     * @param firstname : First Name
     */
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    /**
     * Getter
     *
     * @return Last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter
     *
     * @param lastname : Last Name
     */
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    /**
     * Getter
     *
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     *
     * @param password : Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter
     *
     * @return role
     */

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Setter
     *
     * @param role : Password
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter
     *
     * @return permission
     */
    @JsonProperty("permission")
    public List<String> getPermission() {
        return permission;
    }

    /**
     * Setter
     *
     * @param permission : Password
     */
    @JsonProperty("permission")
    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress1() {
        return Address1;
    }

    /**
     * Setter
     *
     * @param address1 : address2
     */
    public void setAddress1(String address1) {
        Address1 = address1;
    }

    /**
     * Getter
     *
     * @return : address2
     */
    public String getAddress2() {
        return Address2;
    }

    /**
     * Setter
     *
     * @param address2 : address2
     */
    public void setAddress2(String address2) {
        Address2 = address2;
    }

    /**
     * Getter
     *
     * @return : landmark
     */
    public String getLandmark() {
        return landmark;
    }

    /**
     * Setter
     *
     * @param landmark : landmark
     */
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    /**
     * Getter
     *
     * @return : city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter
     *
     * @param city : city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter
     *
     * @return : state
     */
    public String getState() {
        return state;
    }

    /**
     * Setter
     *
     * @param state : state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter
     *
     * @return : country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter
     *
     * @param country : country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter
     *
     * @return : zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter
     *
     * @param zipCode : zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


}
