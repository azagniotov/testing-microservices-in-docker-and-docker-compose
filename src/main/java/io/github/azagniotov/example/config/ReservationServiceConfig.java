package io.github.azagniotov.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationServiceConfig {

    private final String reservationResource;
    private String reservationServiceHost;
    private Integer reservationServicePort;

    public ReservationServiceConfig(@Value("${service.reservation.host}") final String reservationServiceHost,
                                    @Value("${service.reservation.port}") final Integer reservationServicePort,
                                    @Value("${service.reservation.resource}") final String reservationResource) {
        this.reservationServiceHost = reservationServiceHost;
        this.reservationServicePort = reservationServicePort;
        this.reservationResource = reservationResource;
    }

    public String getReservationServiceHost() {
        return reservationServiceHost;
    }

    public Integer getReservationServicePort() {
        return reservationServicePort;
    }

    public String getReservationResource() {
        return reservationResource;
    }
}
