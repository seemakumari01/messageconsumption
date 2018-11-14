package com.messageconsumption.config;


import com.google.common.collect.Lists;
import com.messageconsumption.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration Class
 *
 * @author Seema
 */
@Configuration
@EnableSwagger2
@Profile("true")
public class SwaggerConfig extends WebMvcConfigurationSupport {

    /**
     * @return Docket class object
     * @implNote This fetch all controller inside apis method
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(Constants.BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()).securitySchemes(Lists.newArrayList(apiKey()));
    }

    /**
     * @return ApiInfo class object
     * @implNote Api related main information
     */
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(Constants.API_INFO_TITLE)
                .description(Constants.API_INFO_TITLE)
                .version(Constants.SWAGGER_VERSION)
                .contact(new Contact(Constants.APP_NAME, Constants.URL, Constants.EMAIL))
                .build();
    }

    /**
     * @param registry : Resource Handle Registry
     * @implNote Configure swagger related html,css,js
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constants.PATH_PATTERN_SWAGGER_UI_HTML)
                .addResourceLocations(Constants.RESOURCE_LOCATIONS);
        registry.addResourceHandler(Constants.PATH_PATTERN_WEB_JARS)
                .addResourceLocations(Constants.RESOURCE_LOCATIONS_WEB_JARS);

    }

    /**
     * @return SecurityConfiguration class object
     * @implNote This method use for Authorize button
     */
    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(null, null, null, null,
                StringUtils.EMPTY, ApiKeyVehicle.HEADER, Constants.AUTHORIZATION_HEADER, StringUtils.EMPTY);
    }

    /**
     * @return ApiKey class object
     * @implNote Swagger in header key set
     */
    private ApiKey apiKey() {
        return new ApiKey(Constants.AUTHORIZATION_HEADER, Constants.AUTHORIZATION_HEADER, Constants.PASS_AS_HEADER);
    }

}
