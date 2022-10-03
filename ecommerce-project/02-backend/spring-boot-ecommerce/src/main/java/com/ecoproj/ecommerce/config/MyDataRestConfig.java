package com.ecoproj.ecommerce.config;

import com.ecoproj.ecommerce.entity.Country;
import com.ecoproj.ecommerce.entity.Product;
import com.ecoproj.ecommerce.entity.ProductCategory;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import com.ecoproj.ecommerce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        // disable the methods above for Product: PUT, POST, and DELETE
        disableHttpMethods(Product.class, config, theUnsupportedActions);

        // disable the methods above for Product Category: PUT, POST, and DELETE
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);

        // disable the methods for countries and states
        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(State.class, config, theUnsupportedActions);


        // call internal helper method
        exposeIds(config);
    }

    private static void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids

        // get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create arry of entity types
        List<Class> entityClasses = new ArrayList<>();

        // get entity types for the entities
        for (EntityType temEntityType : entities) {
            entityClasses.add(temEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class[] domainTypes =  entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
        
    }
}