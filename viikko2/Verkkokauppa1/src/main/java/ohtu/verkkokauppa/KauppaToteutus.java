package ohtu.verkkokauppa;

public class KauppaToteutus implements Kauppa {

    private Varasto varasto;
    private Pankki pankki;
    private Ostoskori ostoskori;
    private Viitegeneraattori viitegeneraattori;
    private String kaupanTili;

    public KauppaToteutus(Varasto varasto, Pankki pankki, Viitegeneraattori viitegeneraattori) {
	this.varasto = varasto;
        this.pankki = pankki;
        this.viitegeneraattori = viitegeneraattori;
        this.kaupanTili = "33333-44455";
    }

    @Override
    public void aloitaAsiointi() {
        this.ostoskori = new Ostoskori();
    }

    @Override
    public void poistaKorista(int id) {
        Tuote t = this.varasto.haeTuote(id);
        this.varasto.palautaVarastoon(t);
    }

    @Override
    public void lisaaKoriin(int id) {
        System.out.println(this.varasto.saldo(id));
        if (this.varasto.saldo(id) > 0) {
            Tuote t = this.varasto.haeTuote(id);
            this.ostoskori.lisaa(t);
            this.varasto.otaVarastosta(t);
        }
    }

    @Override
    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = this.viitegeneraattori.uusi();
        int summa = this.ostoskori.hinta();

        return this.pankki.tilisiirto(nimi, viite, tiliNumero, this.kaupanTili, summa);
    }

}
