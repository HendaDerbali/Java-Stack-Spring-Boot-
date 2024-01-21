public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;

    //Constructor: 
    public Item(String name, double price ) {
        this.name = name;
        this.price = price;
        
    }

    //Getters ans Setters - for name :
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getters ans Setters - for price :
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    


}
