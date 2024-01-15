import java.util.ArrayList;

/**
 * CafeUtil
 */
public class CafeUtil {

    // getStreakGoal Method :
    public int getStreakGoal(int numWeeks) {
        int s = 0;
        for (int i = 1; i <= numWeeks; i++) {
            s = s + i;
        }
        System.out.println(s);
        return s;
    }

    // getOrderTotal() Method :
    public double getOrderTotal(Double[] prices) {
        double s = 0;
        for (int i = 0; i < prices.length; i++) {
            s = s + prices[i];
        }
        System.out.println(s);
        return s;
    }

    // displayMenu() Method :
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }

    }

    // addCustomer() Method :
    public void addCustomer(ArrayList<String> customers) {
    System.out.println("Please enter your name:");
    //Add this line of code to get user input from the terminal and store it in the variable username:
    String username = System.console().readLine();
    //Print the username to the console, saying "Hello, [username here]!"
    System.out.println("Hello," + username + "!");
    //Print "There are ___ people in front of you" using the number for how many people are ahead of them (how many items already in the array.)
    System.out.println("There are " + customers.size() +  "people in front of you" );
    //Add the customer's name to the given customers list and print the list.
    customers.add(username);
    System.out.println(customers);


}


}