package org.acme;

import io.quarkus.vertx.ConsumeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingResource {

    private static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

    @ConsumeEvent(value = "test-address", local = false)
    public void hello(String message) {

        log.info("Hello RESTEasy: " + message);
    }

}