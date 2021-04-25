package io.github.azagniotov.example.model;

import io.github.azagniotov.example.config.JacksonConfig;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservationTest {

    @Test
    public void whenDeSerializingUsingJsonCreator_thenCorrect() throws Exception {

        final String json = "{\"Key\":\"p5e20A9hSi2IsV0soVpafQ==\",\"BasePrice\":\"USD10.00\",\"Taxes\":\"EUR19.62\",\"EquivalentBasePrice\":\"EUR9.00\",\"Refundable\":\"false\",\"Exchangeable\":\"false\",\"IssuedDate\":\"2016-07-18T00:00:00.000+03:00\",\"ProviderCode\":\"1G\",\"ProviderLocatorCode\":\"A3TGVW\",\"IATANumber\":\"67320772\",\"PseudoCityCode\":\"36D5\",\"PlatingCarrier\":\"PS\",\"ElStat\":\"A\"}";

        final Reservation reservation = JacksonConfig.OBJECT_MAPPER
                .readerFor(Reservation.class)
                .readValue(json);

        assertEquals("p5e20A9hSi2IsV0soVpafQ==", reservation.getKey());
    }
}