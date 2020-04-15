package ohtu.kivipaperisakset;

public class TekoalyPeli extends Peli {
    Tekoaly tekoaly;

    public TekoalyPeli(IOImplement io, Tuomari tuomari, Tekoaly tekoaly) {
        super(io, tuomari);
        this.tekoaly = tekoaly;
    }

    @Override
    public void annaToinenSiirto() {
        siirto2 = tekoaly.annaSiirto();
        tietokoneenSiirto(siirto2);

    }

    @Override
    public void tokaSiirto() {
        annaToinenSiirto();
        tekoaly.asetaSiirto(siirto1);
    }

    public void tietokoneenSiirto(String siirto) {
        System.out.println("Tietokone valitsi: " + siirto);
    }
}