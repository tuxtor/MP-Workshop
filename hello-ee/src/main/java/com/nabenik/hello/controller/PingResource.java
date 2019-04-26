package com.nabenik.hello.controller;

import com.nabenik.hello.client.HelloResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("hello")
public class PingResource {

    @Inject
    @RestClient
    HelloResource helloResource;

    @GET
    public String hello() {
        String respuesta = "No hay lugar como ";

        return respuesta.concat(helloResource.hello());
    }

}
