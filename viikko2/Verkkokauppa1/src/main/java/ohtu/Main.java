package ohtu;

import ohtu.verkkokauppa.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        ViitegeneraattoriToteutus viitegen = ctx.getBean(ViitegeneraattoriToteutus.class);
        KirjanpitoToteutus kirjanpito      = ctx.getBean(KirjanpitoToteutus.class);
        VarastoToteutus varasto            = ctx.getBean(VarastoToteutus.class);
        PankkiToteutus pankki              = ctx.getBean(PankkiToteutus.class);
        KauppaToteutus kauppa              = ctx.getBean(KauppaToteutus.class);
	

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
