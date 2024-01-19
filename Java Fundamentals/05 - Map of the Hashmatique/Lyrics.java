import java.util.HashMap;
import java.util.Set;

/**
 * Lyrics
 */
public class Lyrics {

    public static void main(String[] args) {
        HashMap<String, String> songsMap = new HashMap<String, String>();
        // userMap.put("nninja@codingdojo.com", "Nancy Ninja");
        songsMap.put("Title1", "Lyrics1");
        songsMap.put("Title2", "Lyrics2");
        songsMap.put("Title3", "Lyrics3");  
        songsMap.put("Title4", "Lyrics4");  

// Pull out one of the songs by its track title.
    String lyric = songsMap.get("Title2");
    System.out.println(lyric); 


 // Print out all the track names and lyrics in the format 'Track: Lyrics'.
Set<String> keys = songsMap.keySet();
        for(String key : keys) {
            System.out.println(key  + ":" + songsMap.get(key));
            // System.out.println(songsMap.get(key)); }
        }
    }    



    
}