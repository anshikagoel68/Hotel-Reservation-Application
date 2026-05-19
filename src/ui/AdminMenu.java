package ui;

import api.AdminResource;
import model.*;
import java.util.*;

public class AdminMenu {

    private static final AdminResource admin = AdminResource.getInstance();
    private static final Scanner scan = new Scanner(System.in);

    public static void adminMenu() {

        while (true) {

            System.out.println("\n...ADMIN MENU...");
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");

            String option = scan.nextLine();

            switch (option) {

                case "1":
                    Collection<Customer> customers = admin.getAllCustomers();
                    if (customers.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        customers.forEach(System.out::println);
                    }
                    break;
                case "2":
                    Collection<IRoom> rooms = admin.getAllRooms();
                    if (rooms.isEmpty()) {
                        System.out.println("No rooms found.");
                    } else {
                        rooms.forEach(System.out::println);
                    }
                    break;
                case "3":
                    admin.displayAllReservations();
                    break;
                case "4":
                    addRoom();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    private static void addRoom() {

        try {

            System.out.println("Enter room number:");
            String roomNo = scan.nextLine();

            if (roomNo == null || roomNo.trim().isEmpty()) {
                throw new IllegalArgumentException("Room number cannot be empty.");
            }
            for (IRoom r : admin.getAllRooms()) {
                if (r.getRoomNumber().equals(roomNo)) {
                    throw new IllegalArgumentException("Room already exists.");
                }
            }
            System.out.println("Enter price:");
            double price = Double.parseDouble(scan.nextLine());
            if (price < 0) {
                throw new IllegalArgumentException("Room price cannot be negative.");
            }
            System.out.println("Enter room type (1 for SINGLE, 2 for DOUBLE):");
            String roomTypeInput = scan.nextLine();
            RoomType type;

            if (roomTypeInput.equals("1")) {
                type = RoomType.SINGLE;
            }
            else if (roomTypeInput.equals("2")) {
                type = RoomType.DOUBLE;
            }
            else {
                throw new IllegalArgumentException("Invalid room type. Enter 1 or 2.");
            }

            IRoom room;

            if (price == 0) {
                room = new FreeRoom(roomNo, type);
            }
            else {
                room = new Room(roomNo, price, type);
            }

            List<IRoom> rooms = new ArrayList<>();
            rooms.add(room);

            admin.addRoom(rooms);

            System.out.println("Room added successfully.");

        }
        catch (NumberFormatException e) {
            System.out.println("Invalid price. Please enter a valid number.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        }
    }
}