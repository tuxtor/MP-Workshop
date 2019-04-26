package com.nabenik.hello.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.resource.spi.ConfigProperty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("home")
@RegisterRestClient
public interface HelloResource {

    @GET
    public String hello();

}