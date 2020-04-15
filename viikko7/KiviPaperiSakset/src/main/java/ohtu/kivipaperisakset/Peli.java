package ohtu.kivipaperisakset;

public abstract class Peli {

    Tuomari tuomari;
    String siirto1;
    String siirto2;
    IOImplement io;
    Tekoaly tekoaly;

    public Peli(IOImplement io, Tuomari tuomari) {
        this.tuomari = tuomari;
        this.io = io;
    }

    public Peli(IOImplement io, Tuomari tuomari, Tekoaly tekoaly) {
        this.tuomari = tuomari;
        this.io = io;
        this.tekoaly = tekoaly;
    }

    public void siirrot() {
        io.ekaSiirto();
        siirto1 = io.get();
        annaToinenSiirto();

        while(sallittuSiirto(siirto1) && sallittuSiirto(siirto2)) {
            
            tuomari.kirjaaSiirto(siirto1, siirto2);
            System.out.println(tuomari);
            
            io.ekaSiirto();
            siirto1 = io.get();
            tokaSiirto();
        }

        io.tulosta("Kiitos!");
        System.out.println(tuomari);
    }

    private boolean sallittuSiirto(String siirto) {
        if(siirto.equals("k") || siirto.equals("p") || siirto.equals("s")) {
            return true;
        }

        return false;
    }

    abstract void annaToinenSiirto();
    abstract void tokaSiirto();

}