package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;
import java.util.*;


public class AdminResource {

    private static AdminResource instance;
    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    private AdminResource() {}

    public static AdminResource getInstance() {

        if(instance == null){
            instance = new AdminResource();
        }
        return instance;
    }
    public Customer getCustomer(String email) {

        return customerService.getCustomer(email);
    }
    public void addRoom(List<IRoom> rooms) {

        for(IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }
    public Collection<IRoom> getAllRooms() {

        return reservationService.findRooms(new java.util.Date(0), new java.util.Date(Long.MAX_VALUE));
    }
    public Collection<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }
    public void displayAllReservations() {

        reservationService.printAllReservation();
    }
}