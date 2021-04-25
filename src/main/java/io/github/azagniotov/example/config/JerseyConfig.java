package io.github.azagniotov.example.config;

import io.github.azagniotov.example.controller.ResourceNotFoundExceptionHandler;
import io.github.azagniotov.example.controller.WebServiceExceptionHandler;
import io.github.azagniotov.example.controller.flights.FlightBookingController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // Controllers
        register(FlightBookingController.class);

        // Exception to HTTP code mappers
        register(ResourceNotFoundExceptionHandler.class);
        register(WebServiceExceptionHandler.class);
    }
}
