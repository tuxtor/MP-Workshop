package com.nabenik.controller;

import com.nabenik.model.Envelope;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("home")
public class HomeResource {

    @Inject
    @ConfigProperty(name = "JAVA_HOME", defaultValue = "a casa do Java")
    String javaHome;

    @Inject
    @Metric
    Counter failCounter;


    @GET
    @Fallback(fallbackMethod = "homeFallback")
    @Timeout(2000)
    @Operation(operationId = "find hello world")
    public Envelope hello() throws  Exception{

        Thread.sleep(15000);

        return new Envelope("Java home", javaHome);
    }



    public Envelope homeFallback() {
        failCounter.inc();
        return new Envelope("Java home", "contate o administrador");
    }

}
