package ohtu.kivipaperisakset;

import java.util.Scanner;

public class IOImplement implements IO{
    Scanner scanner;

    public IOImplement() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void tulosta(String tuloste) {
        System.out.println(tuloste);
    }

    @Override
    public String get() {
        return scanner.nextLine();
    }

    public void ekaSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
    }

    public void pelinPaattyminen() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }
}