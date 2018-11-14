package com.messageconsumption.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Mongo db properties class
 *
 * @author Seema
 */
@Component
public class MongoProperties {

    @Value("${mongodb.db.uri}")
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
