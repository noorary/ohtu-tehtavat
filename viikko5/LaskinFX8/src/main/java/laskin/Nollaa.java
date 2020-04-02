package laskin;

import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Sovelluslogiikka sovelluslogiikka;
    int edellinen;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovelluslogiikka) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovelluslogiikka = sovelluslogiikka;
        edellinen = 0;
    }

    @Override
    public void suorita() {
        int syote = Integer.valueOf(syotekentta.getText());
        edellinen = syote;
        sovelluslogiikka.nollaa();
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