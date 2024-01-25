public class Bat extends Mammal {
    
    //constructor with super is mondatory :/
    //we have error msg if we dont make it
    public Bat (int energy){
        super(300);
    }    


public void fly() {
    this.energy -= 50;
    displayEnergy();
}

public void eatHumans() {
    this.energy += 25;
    displayEnergy();
}

public void attackTown() {
    energy -= 100;
    displayEnergy();
}

}
