package com.messageconsumption.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Application configuration class
 *
 * @author Seema
 */

@Component
public class ApplicationConfiguration {

    private MongoProperties mongoProperties;
    private ApplicationProperties applicationProperties;

    @Autowired
    public ApplicationConfiguration(MongoProperties mongoProperties, ApplicationProperties applicationProperties) {
        this.mongoProperties = mongoProperties;
        this.applicationProperties = applicationProperties;
    }

    public MongoProperties getMongoProperties() {
        return mongoProperties;
    }

    public void setMongoProperties(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }

    public void setApplicationProperties(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }
}
