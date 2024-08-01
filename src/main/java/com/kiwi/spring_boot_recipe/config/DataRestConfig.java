package com.kiwi.spring_boot_recipe.config;

import com.kiwi.spring_boot_recipe.entity.Recipe;
import com.kiwi.spring_boot_recipe.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
// Pour faire la gestion de restriction aux acces aux APIs
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    private String theAllowedOrigin="http://localhost:3000"; // allow to make request from the front end
    private String theOtherAllowedOrigin="http://192.168.0.12:3000";
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
        HttpMethod[] theUnsupportedActions={
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
                HttpMethod.PUT};

        config.exposeIdsFor(Recipe.class);
        config.exposeIdsFor(Review.class);
        disableHttpMethods(Recipe.class,config,theUnsupportedActions);
        disableHttpMethods(Review.class,config,theUnsupportedActions);
        /* configure CORS Mapping */
        cors.addMapping(config.getBasePath()+"/**")
                .allowedOrigins(theAllowedOrigin);

    }

    private void disableHttpMethods(Class theClass,RepositoryRestConfiguration config,HttpMethod[] theUnsupportedActions){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
