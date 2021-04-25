package io.github.azagniotov.example.controller.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

class FlightBookingHttpResponse {

    @JsonProperty
    private final String reservation;

    @JsonProperty
    private final String name;

    @JsonProperty
    private final String phone;

    @JsonProperty
    private final String basePrice;

    @JsonProperty
    private final String taxes;

    FlightBookingHttpResponse(final String reservation,
                              final String name,
                              final String phone,
                              final String basePrice,
                              final String taxes) {
        this.reservation = reservation;
        this.name = name;
        this.phone = phone;
        this.basePrice = basePrice;
        this.taxes = taxes;
    }
}
