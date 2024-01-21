import java.util.ArrayList;

/**
 * Order
 */
public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Gest";
        this.items = new ArrayList<Item>();
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        items = new ArrayList<Item>();

    }

    // GETTERS & SETTERS for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // GETTERS & SETTERS for name

    public Boolean getReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    // GETTERS & SETTERS for item
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    //-------- Order Class Methods:---------------------------------------

    //addItem  method
    public void addItem(Item item) {
        items.add(item);
    }

    //getStatusMessage method
    public String getStatusMessage() {
        String message;
        if (this.ready == true) {
            message = "Your order is ready.";
        } else {
            message = "Thank you for waiting. Your order will be ready soon.";
        }
        System.out.println(message);
        return message;

    }

    //getOrderTotal method : : useenhanced for loop
    public double getOrderTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // display method
    public void display() {
        System.out.println("Customer Name : " + this.name);
        for (Item item : items) {
            System.out.println(item.getName() + "-" + item.getPrice());
        }
        System.out.println("Total: " + " " + getOrderTotal());
    }

}