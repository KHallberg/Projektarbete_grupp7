import java.net.*;
import java.io.*;



public class URLReader {
	
	public static String inputLine;
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
