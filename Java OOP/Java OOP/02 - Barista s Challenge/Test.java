public class Test {

    public static void main(String[] args) {
        Item item1 = new Item("name1", 3.1);
        Item item2 = new Item("name2", 2.1);
        Item item3 = new Item("name3", 1.0);
        Item item4 = new Item("name4", 8.1);

        
        //Create 2 orders for unspecified guests. Do not specify a name.
        Order order1 = new Order();
        Order order2 = new Order();

        //Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Henda");
        Order order4 = new Order("Leila");
        Order order5 = new Order("helean");

        //Implement the addItem, getStatusMessage, getOrderTotal, and display methods within the Order class.
        // order3.addItem(item1);
        // order3.addItem(item2);
        // order3.getStatusMessage();
        // order3.getOrderTotal();
        // order3.display();

        //Add at least 2 items to each of the orders using the addItem method.
        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item2);
        order2.addItem(item2);

        order3.addItem(item3);
        order3.addItem(item3);
 
        order4.addItem(item4);
        order4.addItem(item1);

        order4.addItem(item4);
        order4.addItem(item4);


        // Test your getStatusMessage method by setting some orders to ready and printing the messages for each order.
        order1.setReady(true);
        order5.setReady(true);

        order1.getStatusMessage();
        order2.getStatusMessage();
        order3.getStatusMessage();
        order4.getStatusMessage();
        order5.getStatusMessage();

        //Test the total by printing the return value like so: 'System.out.println(order1.getOrderTotal())'.
        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());
        System.out.println(order3.getOrderTotal());
        System.out.println(order4.getOrderTotal());
        System.out.println(order5.getOrderTotal());


        //Finally, call the display method on all of your orders.
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();








    }
} 
