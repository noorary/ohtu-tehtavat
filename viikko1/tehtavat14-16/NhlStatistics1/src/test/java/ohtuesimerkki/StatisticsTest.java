package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    Player player; 

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
	player = new Player("Lemieux", "PIT", 45, 54);
    }

    @Test
    public void pelaajanHakuPalauttaaTyhjanJosPelaajaaEiOle() {
	assertEquals(null, stats.search("foo"));
    }

    @Test
    public void pelaajanHakuToimii() {
	assertEquals("Gretzky", stats.search("Gretzky").getName());
    }

    @Test
    public void tiiminHakuToimii() {
	assertEquals("Lemieux", stats.team("PIT").get(0).getName());
    }

    @Test
    public void topScorersToimii() {
	assertEquals("Yzerman", stats.topScorers(3).get(2).getName());
    }

    
}





