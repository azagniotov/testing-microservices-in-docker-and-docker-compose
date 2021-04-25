package io.github.azagniotov.example.controller;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebServiceExceptionHandler implements ExceptionMapper<WebServiceException> {

    public Response toResponse(final WebServiceException ex) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ex.getMessage())
                .build();
    }
}
