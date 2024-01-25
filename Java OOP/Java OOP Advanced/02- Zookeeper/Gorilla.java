public class Gorilla extends Mammal {

    //constructor with super is mondatory :/
    //we have error msg if we dont make it
    public Gorilla (int energy){
        super(energy);
    }


    public void throwSomething() {
        this.energy -= 5;
        System.out.println("the gorilla has thrown something");
    }


    public void eatBananas() {
        this.energy += 10;
        System.out.println("The Gorilla is satusfied");
        
    }

    public void climb() {
        this.energy -= 10;
        System.out.println("The Gorilla has climed a tree");
        
        
    }

}
