package com.messageconsumption;

/**
 * @author Seema
 */
public final class Constants {
    private Constants() {
    }

    public static final String BASE_API_URL = "/messageconsumption/api/v1";
    public static final String BASE_PUBLIC_API_URL = BASE_API_URL + "/public";
    public static final String APP_NAME = "MessageConsumption";
    public static final String USER_SERVICE = "userService";
    public static final String BASE_PACKAGE = "com.messageconsumption.rest.controller";


    //Security
    public static final String SIGNING_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@&#";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String PASS_AS_HEADER = "header";

    //SwaggerConfig
    public static final String PATH_PATTERN_SWAGGER_UI_HTML = "swagger-ui.html";
    public static final String RESOURCE_LOCATIONS = "classpath:/META-INF/resources/";
    public static final String PATH_PATTERN_WEB_JARS = "/webjars/**";
    public static final String RESOURCE_LOCATIONS_WEB_JARS = "classpath:/META-INF/resources/webjars/";
    public static final String API_INFO_TITLE = "Message Processing REST API";

    public static final String SWAGGER_VERSION = "1.0.0";
    public static final String URL = "http://localhost:8080";
    public static final String EMAIL = "seema.decipher@decipherzone.com";

}
