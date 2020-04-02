package laskin;

import java.util.HashMap;
import java.util.Map;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import laskin.Summa;
import laskin.Erotus;
import laskin.Komento;
import laskin.Nollaa;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta; 
    private TextField syotekentta; 
    private Map<Button, Komento> komennot;
    private Komento edellinen = null;
    private Button undo;
    private Sovelluslogiikka sovellus;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();

        komennot = new HashMap<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta, sovellus) );
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, sovellus) );
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, sovellus) );
    }
    
    @Override
    public void handle(Event event) {
        if ( event.getTarget() != undo ) {
            Komento komento = komennot.get(event.getTarget());
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }                  
    }

}
