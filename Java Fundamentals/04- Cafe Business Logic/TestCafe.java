import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil cafeUtil = new CafeUtil();

        // Method 01
        cafeUtil.getStreakGoal(10);
        cafeUtil.getStreakGoal(50);

        // Method 02
        Double[] prices = { 1.0, 1.2, 0.0 };
        cafeUtil.getOrderTotal(prices);

        // Method 03
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");

        cafeUtil.displayMenu(menuItems);

        // Method 04
        ArrayList<String> customers = new ArrayList<String>();
        // Test 4 times
        for (int i = 0; i < 4; i++) {
            cafeUtil.addCustomer(customers);
        }

    }
}
