package com.messageconsumption.config;


import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.messageconsumption.exceptions.InitializationException;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jongo.Jongo;
import org.jongo.marshall.jackson.JacksonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Database configuration class
 *
 * @author Seema
 */
@Configuration
public class DBConfig {

    private static final Logger LOGGER = LogManager.getLogger(DBConfig.class);

    private final ApplicationConfiguration applicationConfiguration;

    @Autowired
    public DBConfig(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    /**
     * @return Jongo Object class
     * @implNote This method is used to get mongo database configuration with jongo
     */
    @Bean
    public Jongo getDbConfig() {
        try {
            String uri = applicationConfiguration.getMongoProperties().getUri();
            MongoClientURI clientURI = new MongoClientURI(uri);
            MongoClient client = new MongoClient(clientURI);
            DB db = new DB(client, client.getDatabase(clientURI.getDatabase()).getName());


            db.setWriteConcern(WriteConcern.ACKNOWLEDGED);
            return new Jongo(db,
                    new JacksonMapper.Builder()
                            .registerModule(new JodaModule())
                            .enable(MapperFeature.AUTO_DETECT_GETTERS)
                            .build());


        } catch(Exception e) {
            throw new InitializationException(e.getMessage(), e);
        }
    }

}
