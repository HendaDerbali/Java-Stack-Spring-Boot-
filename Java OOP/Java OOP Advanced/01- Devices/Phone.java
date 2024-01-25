public class Phone extends Device {

    public void makeCall() {
        System.out.println("Making a call :");
        batterie -= 5;
        status();
    }


    public void playGame() {
        System.out.println("Playing a game :");
        batterie -= 20;
        status();  
    }


    public void charge() {
        System.out.println("Charging :");
        batterie += 50; 
        status();
    }
    
}
