package io.github.azagniotov.example.controller;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionHandler implements ExceptionMapper<ResourceNotFoundException> {

    public Response toResponse(ResourceNotFoundException ex) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Resource not found")
                .build();
    }
}
