/**
 * Mammal
 */
public class Mammal {
protected int  energy = 100;

protected  void displayEnergy() {
    System.out.println("The energy level : " + energy);
    
} 

//Constructor that make as change the valur of the energie later : 
public Mammal (int energy){
    this.energy = energy;
}

    
}