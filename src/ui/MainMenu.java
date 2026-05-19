package ui;

import api.HotelResource;
import model.IRoom;
import model.Reservation;
import java.text.*;
import java.util.*;

public class MainMenu {

    private static final HotelResource hotel = HotelResource.getInstance();
    private static final Scanner scan = new Scanner(System.in);

    public static void mainMenu() {

        while (true) {

            System.out.println("\n...HOTEL RESERVATION MENU...");
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");

            String option = scan.nextLine();

            switch (option) {

                case "1":
                    findAndReserveRoom();
                    break;
                case "2":
                    seeReservations();
                    break;
                case "3":
                    createAccount();
                    break;
                case "4":
                    AdminMenu.adminMenu();
                    break;
                case "5":
                    System.out.println("Thank you for using the hotel reservation application!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
   private static void createAccount() {

    try {

        System.out.println("Enter email:");
        String email = scan.nextLine();

        System.out.println("Enter first name:");
        String firstName = scan.nextLine();

        System.out.println("Enter last name:");
        String lastName = scan.nextLine();

        hotel.createACustomer(email, firstName, lastName);

        System.out.println("Account created successfully.");

    } catch (IllegalArgumentException e) {

        System.out.println("Error: " + e.getMessage());
        System.out.println("Please enter a valid email like name@domain.com");

    } catch (Exception e) {

        System.out.println("Unexpected error occurred.");

    }
}
    private static void seeReservations() {

        System.out.println("Enter your email:");
        String email = scan.nextLine();

        if (hotel.getCustomer(email) == null) {
            System.out.println("Account not found.");
            return;
        }
        Collection<Reservation> reservations =hotel.getCustomersReservations(email);
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } 
        else {
            for (Reservation r : reservations) {
                System.out.println(r);
            }
        }
    }
   private static void findAndReserveRoom() {

    try {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        System.out.println("Enter Check-in Date (dd/MM/yyyy):");
        Date checkIn = format.parse(scan.nextLine());

        System.out.println("Enter Check-out Date (dd/MM/yyyy):");
        Date checkOut = format.parse(scan.nextLine());

        if (!checkOut.after(checkIn)) {
            System.out.println("Check-out date must be after check-in date.");
            return;
        }

        Collection<IRoom> availableRooms = hotel.findARoom(checkIn, checkOut);

        if (availableRooms.isEmpty()) {

            System.out.println("No rooms available for selected dates.");
            System.out.println("Checking availability after 7 days...");

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(checkIn);
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            Date fallbackCheckIn = calendar.getTime();

            calendar.setTime(checkOut);
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            Date fallbackCheckOut = calendar.getTime();

            availableRooms = hotel.findARoom(fallbackCheckIn, fallbackCheckOut);

            if (availableRooms.isEmpty()) {
                System.out.println("No rooms available even after 7 days.");
                return;
            }

            checkIn = fallbackCheckIn;
            checkOut = fallbackCheckOut;

            System.out.println("Recommended rooms for new dates:");
        }

        for (IRoom room : availableRooms) {
            System.out.println(room);
        }

        System.out.println("Enter your email:");
        String email = scan.nextLine();

        if (hotel.getCustomer(email) == null) {
            System.out.println("Account not found. Please create an account first.");
            return;
        }

        System.out.println("Enter room number:");
        String roomNumber = scan.nextLine();

        IRoom selectedRoom = null;

        for (IRoom room : availableRooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room not found.");
            return;
        }

        Reservation reservation =
                hotel.bookARoom(email, selectedRoom, checkIn, checkOut);

        System.out.println("\nReservation successful!");
        System.out.println(reservation);

    } catch (ParseException e) {

        System.out.println("Invalid date format. Use dd/MM/yyyy.");

    } catch (Exception e) {

        System.out.println("Error: " + e.getMessage());

    }
}
}