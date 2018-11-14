package com.messageconsumption.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @param <T>
 * @author Seema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse<T> {

    private int code;

    private String desc;

    private T payload;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "APIResponse [code=" + code + ", desc=" + desc + ", payload=" + payload + "]";
    }
}