package model;
import java.util.*;
public class Reservation {

    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(Customer c, IRoom r,Date checkInDate, Date checkOutDate) {

        if (!checkOutDate.after(checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }
        this.customer = c;
        this.room = r;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    public Customer getCustomer() {
        return customer;
    }
    public IRoom getRoom() {
        return room;
    }
    public Date getCheckInDate() {
        return checkInDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public String toString() {
        return "Reservation:\nCustomer: " + customer +
                "\nRoom: " + room +
                "\nCheck-In: " + checkInDate +
                "\nCheck-Out: " + checkOutDate;
    }
}