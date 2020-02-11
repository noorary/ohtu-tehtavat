package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class ViitegeneraattoriToteutus implements Viitegeneraattori {

    private static int seuraava = 1;

    @Override
    public int uusi() {
	return seuraava++;
    }
}
