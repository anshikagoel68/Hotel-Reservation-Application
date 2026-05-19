package model;

import java.util.regex.Pattern;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String email;

    private static final String EMAIL_REGEX = "^[^@]+@[^@]+\\.[^@]+$";

    public Customer(String firstName, String lastName, String email) {

        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Email format not valid");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Customer: " + firstName + " " + lastName + ", Email: " + email;
    }
}