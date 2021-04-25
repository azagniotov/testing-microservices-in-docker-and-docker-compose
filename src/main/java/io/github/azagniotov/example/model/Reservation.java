package io.github.azagniotov.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {

    private final String key;
    private final String basePrice;
    private final String taxes;

    @JsonCreator
    public Reservation(@JsonProperty("Key") final String key,
                       @JsonProperty("BasePrice") final String basePrice,
                       @JsonProperty("Taxes") final String taxes) {
        this.key = key;
        this.basePrice = basePrice;
        this.taxes = taxes;
    }

    public String getKey() {
        return key;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public String getTaxes() {
        return taxes;
    }
}
