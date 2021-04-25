package io.github.azagniotov.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation4xxClientError {

    private final String faultCode;
    private final String faultCodeDesc;
    private final String faultString;

    @JsonCreator
    public Reservation4xxClientError(@JsonProperty("faultCode") final String faultCode,
                                     @JsonProperty("faultCodeDesc") final String faultCodeDesc,
                                     @JsonProperty("faultString") final String faultString) {
        this.faultCode = faultCode;
        this.faultCodeDesc = faultCodeDesc;
        this.faultString = faultString;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public String getFaultCodeDesc() {
        return faultCodeDesc;
    }

    public String getFaultString() {
        return faultString;
    }
}
