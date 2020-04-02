package laskin;

import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Erotus extends Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Sovelluslogiikka sovelluslogiikka;
    int edellinen;

    public Erotus(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovelluslogiikka) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovelluslogiikka = sovelluslogiikka;
        edellinen = 0;

    }

    @Override
    public void suorita() {
        int syote = Integer.valueOf(syotekentta.getText());
        edellinen = syote;
        sovelluslogiikka.miinus(syote);
        arvoUI();
    }

    @Override
    public void peru() {
        sovelluslogiikka.plus(edellinen);
        arvoUI();
    }

    public void arvoUI() {
        tuloskentta.setText(String.valueOf(sovelluslogiikka.tulos()));
    }

}