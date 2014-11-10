package com.axemblr.dropwizard.swagger;

import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Environment;

import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;

public class SwaggerBundle extends AssetsBundle {

    public static final String DEFAULT_PATH = "/swagger";

    public SwaggerBundle() {
        super(DEFAULT_PATH);
    }

    @Override
    public void run(Environment environment) {
        environment.addResource(new ApiListingResourceJSON());

        environment.addProvider(new ResourceListingProvider());
        environment.addProvider(new ApiDeclarationProvider());
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new DefaultJaxrsApiReader());

        super.run(environment);

//        SwaggerConfig config = ConfigFactory.config();
//        config.setApiVersion("1.0.1");
//        config.setBasePath("http://localhost:8000");
    }
}
