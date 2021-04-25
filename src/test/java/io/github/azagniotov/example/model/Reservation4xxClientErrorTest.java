package io.github.azagniotov.example.model;

import io.github.azagniotov.example.config.JacksonConfig;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Reservation4xxClientErrorTest {

    @Test
    public void whenDeSerializingUsingJsonCreator_thenCorrect() throws Exception {

        final String json = "{ \"detail\": { \"common_v47_0:ErrorInfo\": { \"common_v47_0:Auxdata\": { \"common_v47_0:Entry\": { \"common_v47_0:Description\": \"SearchAirLeg.DepTimes\", \"common_v47_0:Reason\": \"element\" } }, \"common_v47_0:Code\": \"3003\", \"common_v47_0:Description\": \"Preferred date-time is before the current departure city date-time.\", \"common_v47_0:Service\": \"AIRSEARCH_SERVICE\", \"common_v47_0:TraceId\": \"0fb9f82e-672d-29dd-67b1-ca40ec36efd0\", \"common_v47_0:TransactionId\": \"F5A926460A074258BACEB18FBC781778\", \"common_v47_0:Type\": \"ValidationException\", \"xmlns:common_v47_0\": \"http://www.travelport.com/schema/common_v47_0\" } }, \"faultCode\": \"400\", \"faultCodeDesc\": \"Server.ValidationException\", \"faultString\": \"Preferred date-time is before the current departure city date-time.\" }";

        final Reservation4xxClientError reservation4xxClientError = JacksonConfig.OBJECT_MAPPER
                .readerFor(Reservation4xxClientError.class)
                .readValue(json);

        assertEquals("Server.ValidationException", reservation4xxClientError.getFaultCodeDesc());
    }

    @Test
    public void whenDeSerializingUsingJsonCreator_thenUnexpectedJson() throws Exception {

        final String json = "{ \"unexpectedJsonProperty\": \"403\", \"unexpectedJsonPropertyDesc\": \"ValidationException\", \"unexpectedJsonPropertyLongDesc\": \"Something long and descriptive about the ValidationException\" }";

        final Reservation4xxClientError reservation4xxClientError = JacksonConfig.OBJECT_MAPPER
                .readerFor(Reservation4xxClientError.class)
                .readValue(json);

        assertNull(reservation4xxClientError.getFaultCode());
        assertNull(reservation4xxClientError.getFaultCodeDesc());
        assertNull(reservation4xxClientError.getFaultString());
    }
}