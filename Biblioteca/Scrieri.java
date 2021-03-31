package Biblioteca;

import java.util.Date;

public class Scrieri {
    protected static Integer nrScrieri=0;
    protected Integer id;
    protected String nume;
    protected String anulPublicarii;
    protected boolean imprumut = true;

    public Scrieri(){

    }

    public Scrieri( String nume, String anulPublicarii) {
        id = ++ nrScrieri;
        this.nume = nume;
        this.anulPublicarii = anulPublicarii;
    }

    public String getNume() {
        return nume;
    }

    public Integer getId() {
        return id;
    }

    public boolean getImprumut() {
        return imprumut;
    }

    public String getAnulPublicarii() { return anulPublicarii; }

    public void setImprumut(boolean imprumut) {
        this.imprumut = imprumut;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nume: " + nume + "\n" +
                "Anul publicarii: " + anulPublicarii + "\n" +
                "Imprumutata: " + imprumut +"\n";
    }
}
