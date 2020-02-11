package ohtu.verkkokauppa;

public class PankkiToteutus implements Pankki {

    private Kirjanpito kirjanpito;

    public PankkiToteutus(Kirjanpito kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
	kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tililta + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

	// täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;

    } 
}
