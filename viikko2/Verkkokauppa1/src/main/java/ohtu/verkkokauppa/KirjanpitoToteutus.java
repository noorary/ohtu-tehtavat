
package ohtu.verkkokauppa;

import java.util.ArrayList;

public class KirjanpitoToteutus implements Kirjanpito {

    private static ArrayList<String> tapahtumat = new ArrayList<>();

    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }
      
}
