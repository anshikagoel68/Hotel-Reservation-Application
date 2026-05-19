package service;

import model.*;

import java.util.*;

public class ReservationService {

    private static ReservationService instance = null;

    private final Map<String, IRoom> rooms = new HashMap<>();
    private final List<Reservation> reservations = new ArrayList<>();

    private ReservationService() {}

    public static ReservationService getInstance() {

        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public void addRoom(IRoom room) {

        if (room == null || room.getRoomNumber() == null || room.getRoomNumber().isEmpty()) {
            throw new IllegalArgumentException("Room number cannot be empty.");
        }

        if (rooms.containsKey(room.getRoomNumber())) {
            throw new IllegalArgumentException("Room already exists.");
        }

        rooms.put(room.getRoomNumber(), room);
    }

    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    public IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        for (Reservation reservation : reservations) {

            if (reservation.getRoom().equals(room) &&
                reservation.getCheckInDate().before(checkOutDate) &&
                reservation.getCheckOutDate().after(checkInDate)) {

                throw new IllegalArgumentException("Room already booked for these dates.");
            }
        }

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        List<IRoom> availableRooms = new ArrayList<>(rooms.values());

        for (Reservation reservation : reservations) {

            if (reservation.getCheckInDate().before(checkOutDate) &&
                reservation.getCheckOutDate().after(checkInDate)) {

                availableRooms.remove(reservation.getRoom());
            }
        }

        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {

        List<Reservation> customerReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {

            if (reservation.getCustomer().equals(customer)) {
                customerReservations.add(reservation);
            }
        }

        return customerReservations;
    }

    public void printAllReservation() {

        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }

        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}