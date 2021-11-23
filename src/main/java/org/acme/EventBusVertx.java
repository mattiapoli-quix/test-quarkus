package org.acme;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryContext;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.impl.VertxInternal;
import io.vertx.eblink.EventBusLink;
import io.vertx.eblink.EventBusLinkOptions;
import io.vertx.eblink.impl.EventBusLinkImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.function.Consumer;

@ApplicationScoped
public class EventBusVertx {
    private static final Logger log = LoggerFactory.getLogger(EventBusVertx.class);

    @Inject
    Vertx vertx;


    void startup(@Observes StartupEvent event) {

        EventBusLinkOptions defaultOptions = new EventBusLinkOptions()
                .setServerHost("localhost")
                .setServerPort(8080)
                .setClientHost("localhost")
                .setClientPort(8180);

        EventBusLink.createShared(vertx, defaultOptions, ar -> {

            if (!ar.succeeded()) {
                log.info("Failed to initialize Link: " + ar.cause());
                return;
            }

            log.info("WebSocket has been bound");
//            ar.result().addInboundInterceptor((Handler<DeliveryContext<String>>) deliveryContext -> {
//                log.info("inbound: Incoming from: " + deliveryContext.message().address() + " message: " + deliveryContext.message().body());
//                deliveryContext.next();
//            });
//            ar.result().addOutboundInterceptor((Handler<DeliveryContext<String>>) deliveryContext -> {
//                String address = deliveryContext.message().address();
//                log.info("outbound: send to address: " + address + " message: " + deliveryContext.body());
//                deliveryContext.next();
//            });


        });

    }


}
