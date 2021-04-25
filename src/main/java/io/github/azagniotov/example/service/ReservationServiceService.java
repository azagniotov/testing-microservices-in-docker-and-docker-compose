package io.github.azagniotov.example.service;

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import io.github.azagniotov.example.config.ReservationServiceConfig;
import io.github.azagniotov.example.controller.WebServiceException;
import io.github.azagniotov.example.io.HttpUtils;
import io.github.azagniotov.example.model.Reservation;
import io.github.azagniotov.example.model.Reservation4xxClientError;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response.Status.Family;
import java.io.IOException;

import static io.github.azagniotov.example.config.JacksonConfig.OBJECT_MAPPER;
import static javax.ws.rs.core.Response.Status.Family.familyOf;

@Component
public class ReservationServiceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceService.class);

    private final ReservationServiceConfig reservationServiceConfig;

    public ReservationServiceService(final ReservationServiceConfig reservationServiceConfig) {
        this.reservationServiceConfig = reservationServiceConfig;
    }

    Reservation get(final Long id) throws IOException {

        final String requestUrl = String.format("%s:%s/%s/%s",
                reservationServiceConfig.getReservationServiceHost(),
                reservationServiceConfig.getReservationServicePort(),
                reservationServiceConfig.getReservationResource(),
                id);

        LOGGER.info("Hitting Reservation on {}", requestUrl);

        final HttpRequest request = HttpUtils.constructHttpRequest(HttpMethods.GET, requestUrl);
        final HttpResponse response = request.execute();

        final String rawResponseContent = response.parseAsString().trim();
        if (response.getStatusCode() == HttpStatus.SC_OK) {
            return OBJECT_MAPPER.readValue(rawResponseContent, Reservation.class);
        } else if (familyOf(response.getStatusCode()) == Family.CLIENT_ERROR) {
            final Reservation4xxClientError reservation4xxClientError = OBJECT_MAPPER.readValue(rawResponseContent, Reservation4xxClientError.class);

            final String errorJson = OBJECT_MAPPER.writeValueAsString(reservation4xxClientError);

            LOGGER.debug(errorJson);
            throw new WebServiceException("{\"code\": 500, \"message\": \"" + reservation4xxClientError.getFaultCodeDesc() + "\"}");
        } else {
            throw new WebServiceException(rawResponseContent);
        }
    }
}
