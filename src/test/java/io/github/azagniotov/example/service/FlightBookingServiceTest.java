package io.github.azagniotov.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class FlightBookingServiceTest {

    @Mock
    private AccountServiceService accountServiceService;

    @Mock
    private ReservationServiceService reservationServiceService;

    @InjectMocks
    private FlightBookingService flightBookingService;

    @Test
    public void shouldThrowWhenCouldNotFindResource() throws Exception {
        assertTrue(true);
    }
}