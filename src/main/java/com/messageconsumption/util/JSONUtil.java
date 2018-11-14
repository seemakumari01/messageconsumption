package com.messageconsumption.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messageconsumption.exceptions.UnrecoverableException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Seema
 */
public class JSONUtil {

    private static final Logger LOGGER = LogManager.getLogger(JSONUtil.class);

    private JSONUtil() {
    }

    public static <T> T loadJson(final String json, final Class<T> clazz) {
        final ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        try {
            return mapper.readerFor(clazz).readValue(json);
        } catch(Exception e) {
            throw new UnrecoverableException(e);
        }
    }

    public static String toJson(final Object o) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(o);
        } catch(Exception e) {
            throw new UnrecoverableException(e);
        }
    }
}
