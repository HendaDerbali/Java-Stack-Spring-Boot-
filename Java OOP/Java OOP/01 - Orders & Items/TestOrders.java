
public class TestOrders {
    public static void main(String[] args) {

        // Menu items :
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 3.2;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 2.5;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 0.8;

        Item item4 = new Item();
        item4.name = "cappuccino";
        item4.price = 8.8;

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.total = 5.2;
        order1.ready = false;

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.total = 5.5;
        order2.ready = false;

        Order order3 = new Order();
        order3.name = "Noah";
        order3.total = 5.5;
        order3.ready = false;

        Order order4 = new Order();
        order4.name = "Sam";
        order4.total = 5.5;
        order4.ready = false;

        // Application Simulations
        // Print the order1 variable to the console to see what happens.
        System.out.println(order1);
        // Predict what will happen if you print 'order1.total'.
        System.out.println(order1.total);

        // Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total = order2.total + item1.price;

        // Noah ordered a cappuccino. Add the cappuccino to their order list and to
        // their tab.
        order3.items.add(item4);
        order3.total += item4.price;

        // Sam added a latte. Update the order accordingly.
        order4.items.add(item2);
        order4.total += item2.price;

        // Cindhuri’s order is now ready. Update her status.
        order1.ready = true;

        // Sam ordered more drinks: 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        // Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Use this example code to test various orders' updates
        System.out.println("-------order 1------------");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.println("-------order 2------------");
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.println("-------order 3------------");
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.println("-------orde4 1------------");
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);

    }

}
