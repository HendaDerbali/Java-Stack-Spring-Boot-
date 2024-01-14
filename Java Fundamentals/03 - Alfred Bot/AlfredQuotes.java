
/**
 * AlfredQuotes
 */
import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        // MY CODE ADDED :
        return String.format("Hello, %s Lovely to see you.", name);
    }

    public String dateAnnouncement() {
        // MY CODE ADDED :
        Date date = new Date();
        return String.format("It is currently %s", date);
    }

    public String respondBeforeAlexis(String conversation) {
        // MY CODE ADDED :
        return conversation;
    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    public String guestGreeting(String name, String lastName) {
        // MY CODE ADDED :
        return String.format("Hello, %s %s Lovely to see you.", name, lastName);
    }

    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have
    // learned!
}
