package io.github.azagniotov.example.model;

import java.util.Objects;

public class FlightBooking {

    private final Account account;
    private final Reservation reservation;

    public FlightBooking(final Account account, final Reservation reservation) {
        this.account = account;
        this.reservation = reservation;
    }

    public String getName() {
        return this.account.getName();
    }

    public String getPhone() {
        return this.account.getPhone();
    }

    public String getReservationKey() {
        return this.reservation.getKey();
    }

    public String getBasePrice() {
        return this.reservation.getBasePrice();
    }

    public String getTaxes() {
        return this.reservation.getTaxes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightBooking)) return false;
        FlightBooking that = (FlightBooking) o;
        return getName().equals(that.getName()) &&
                getReservationKey().equals(that.getReservationKey()) &&
                getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getReservationKey(), getPhone());
    }
}
