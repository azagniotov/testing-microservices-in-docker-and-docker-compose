package io.github.azagniotov.example.service;

import io.github.azagniotov.example.model.Account;
import io.github.azagniotov.example.model.FlightBooking;
import io.github.azagniotov.example.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FlightBookingService {

    private final AccountServiceService accountServiceService;
    private final ReservationServiceService reservationServiceService;

    @Autowired
    public FlightBookingService(final AccountServiceService accountServiceService,
                                final ReservationServiceService reservationServiceSerbice) {
        this.accountServiceService = accountServiceService;
        this.reservationServiceService = reservationServiceSerbice;
    }

    public FlightBooking get(final Long id) throws IOException {
        final Account account = accountServiceService.get(id);
        final Reservation reservation = reservationServiceService.get(id);

        return new FlightBooking(account, reservation);
    }
}
