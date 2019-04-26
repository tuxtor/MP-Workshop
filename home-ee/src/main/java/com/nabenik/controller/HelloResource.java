package com.nabenik.controller;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Path("home")
public class HelloResource {

    @Inject
    @ConfigProperty(name = "JAVA_HOME", defaultValue = "la casa de java")
    String javaHome;

    @Inject
    @Metric
    Counter failCounter;




    @GET
    @Fallback(fallbackMethod = "helloFallback")
    @Timeout(2000)
    @Operation(operationId = "find hello world")
    public String hello() throws  Exception{

        Thread.sleep(15000);

        return javaHome;
    }



    public String helloFallback() {
        failCounter.inc();
        return "Como el hogar";
    }

}
