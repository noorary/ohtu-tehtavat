package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        Date dateNow = new Date( );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("E MMM dd HH:mm:ss zzz yyyy");

        Arrays.sort(players);

        System.out.println("Players from FIN: " + simpleDateFormat.format(dateNow));
        for (Player player : players) {
            if(player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
            
        }   
    }
}
  
