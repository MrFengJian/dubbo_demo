package com.sevenlu.dubbo.api;

import com.sevenlu.dubbo.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/demo")
public interface DemoService {

    @Path("/say-hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String sayHello(@QueryParam("name") String input);

    @Path("/get-user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    User getUser(@QueryParam("name") String name);
}
