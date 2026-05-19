import model.Customer;

public class Driver {
    public static void main(String[] args) {
        try {
            Customer cust =new Customer("first", "second", "j@domain.com");
            System.out.println(cust);
            Customer invalid = new Customer("first", "second", "email");
            System.out.println(invalid);

        } 
        catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}