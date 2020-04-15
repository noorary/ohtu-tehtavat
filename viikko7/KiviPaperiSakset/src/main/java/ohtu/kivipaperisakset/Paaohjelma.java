package ohtu.kivipaperisakset;


public class Paaohjelma {


    public static void main(String[] args) {

        IOImplement io = new IOImplement();

        while (true) {
            Tuomari tuomari = new Tuomari();
            TekoalyTyhma tyhma = new TekoalyTyhma();
            TekoalyParannettu parannettu = new TekoalyParannettu(20);

            io.tulosta("\nValitse pelataanko"
            + "\n (a) ihmistä vastaan "
            + "\n (b) tekoälyä vastaan"
            + "\n (c) parannettua tekoälyä vastaan"
            + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.get();
            if (vastaus.endsWith("a")) {
                io.pelinPaattyminen();
                Peli kaksinpeli = Tehdas.ihminenVSihminen(io, tuomari);
                kaksinpeli.siirrot();
            } else if (vastaus.endsWith("b")) {
                io.pelinPaattyminen();
                Peli yksinpeli = Tehdas.ihminenVStekoaly(io, tuomari, tyhma);
                yksinpeli.siirrot();
            } else if (vastaus.endsWith("c")) {
                io.pelinPaattyminen();
                Peli pahaYksinpeli = Tehdas.ihminenVStekoaly(io, tuomari, parannettu);
                pahaYksinpeli.siirrot();
            } else {
                break;
            }

        }

    }
}
