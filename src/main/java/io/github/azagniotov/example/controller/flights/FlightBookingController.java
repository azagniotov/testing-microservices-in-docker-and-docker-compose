package io.github.azagniotov.example.controller.flights;

import io.github.azagniotov.example.model.FlightBooking;
import io.github.azagniotov.example.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

@RestController
@Path("/v1/flights")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    @Autowired
    FlightBookingController(final FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @GET
    @Path("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public FlightBookingHttpResponse get(@PathParam("id") Long id) throws IOException {
        final FlightBooking flightBooking = flightBookingService.get(id);

        return new FlightBookingHttpResponse(
                flightBooking.getReservationKey(),
                flightBooking.getName(),
                flightBooking.getPhone(),
                flightBooking.getBasePrice(),
                flightBooking.getTaxes());
    }
}


