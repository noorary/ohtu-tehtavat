package ohtu.kivipaperisakset;

public class Tehdas extends Peli{

    public Tehdas(IOImplement io, Tuomari tuomari) {
        super(io, tuomari);
    }

    public Tehdas(IOImplement io, Tuomari tuomari, Tekoaly tekoaly) {
        super(io, tuomari, tekoaly);
    }

    static public Peli ihminenVSihminen(IOImplement io, Tuomari tuomari) {
        return new Tehdas(io, tuomari);
    }

    static public Peli ihminenVStekoaly(IOImplement io, Tuomari tuomari, Tekoaly tekoaly) {
        return new TekoalyPeli(io, tuomari, tekoaly);
    }

    @Override
    public void annaToinenSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        siirto2 = io.get();
    }

    @Override
    public void tokaSiirto() {
        annaToinenSiirto();
    }

}