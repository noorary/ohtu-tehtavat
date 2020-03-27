
package ohtu.intjoukkosovellus;

public class IntJoukko { 

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
                                                // näin paljon isompi kuin vanha
    private int kasvatuskoko;
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        taulukko = new int[KAPASITEETTI];
        
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
        alustaTaulukko(taulukko);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti > 0) {

            taulukko = new int[kapasiteetti];
            alkioidenLkm = 0;
            this.kasvatuskoko = OLETUSKASVATUS;
            alustaTaulukko(taulukko);
        } else {
            throw new IndexOutOfBoundsException("Kapasiteetin tulee olla suurempi kuin nolla");
        }
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        
        if(kapasiteetti > 0 && kasvatuskoko > 0) {
            taulukko = new int[kapasiteetti];
            alkioidenLkm = 0;
            this.kasvatuskoko = kasvatuskoko;
            alustaTaulukko(taulukko);
        } else {
            throw new IndexOutOfBoundsException("Kapasiteetin ja kavatuskoon tulee olla suurempi kuin nolla");
        }
    }

    private void alustaTaulukko(int[] taulukko) {
        for(int i=0; i<taulukko.length;i++) {
            taulukko[i] = 0;
        }
    }

    public boolean lisaa(int luku) {

        
        if (!loytyyTaulukosta(luku)) {
            taulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == taulukko.length) {

                int[] uusitaulukko = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukko, uusitaulukko);
                taulukko = uusitaulukko;
                
            }
            return true;
        }
        return false;
    }


    public boolean loytyyTaulukosta(int etsittavaLuku) {

        for (int i = 0; i < alkioidenLkm; i++) {
            if (etsittavaLuku == taulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poistaLuku(int luku) {

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                siirraLukuja(i, alkioidenLkm);
                alkioidenLkm--;
                return true;
            }
            
        }

        return false;
    }

    private void siirraLukuja(int i, int alkioidenLkm) {

        for(int j=i; j<alkioidenLkm-1; j++) {
            taulukko[j] = taulukko[j+1];
        }
        

    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int alkioidenMaara() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + taulukko[0] + "}";
        } else {
            String tuloste = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuloste += taulukko[i];
                tuloste += ", ";
            }
            tuloste += taulukko[alkioidenLkm - 1];
            tuloste += "}";
            return tuloste;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko palautettava = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            palautettava.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            palautettava.lisaa(bTaulu[i]);
        }
        return palautettava;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko palautettava = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    palautettava.lisaa(bTaulu[j]);
                }
            }
        }
        return palautettava;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko palautettava = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            palautettava.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            palautettava.poistaLuku(bTaulu[i]);
        }
 
        return palautettava;
    }
        
}
