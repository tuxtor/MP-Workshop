package com.nabenik.hello.controller;

import com.nabenik.hello.client.HomeResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("hello")
public class HelloResource {

    @Inject
    @RestClient
    HomeResource homeResource;

    @GET
    public String hello() {
        String resposta = "Ola desde Jakarta EE Live";
        var envelope = homeResource.hello();

        return resposta.concat(envelope.getDescription());
    }

}
