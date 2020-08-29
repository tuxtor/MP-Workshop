package com.nabenik.hello.client;

import com.nabenik.hello.model.EnvelopeDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("home")
@RegisterRestClient
public interface HomeResource {

    @GET
    public EnvelopeDTO hello();

}
