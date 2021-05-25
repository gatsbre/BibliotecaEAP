package carte;

import persoana.Autor;

import java.util.Date;

public class Carte {
    private static Integer nrCarti = 0;
    private Integer idCarte;
    private String nume;
    private Integer idAutor;
    private String anulPublicarii;
    private boolean imprumutata;

    public Carte(String nume, Integer idAutor, String anulPublicarii) {
        idCarte = ++ nrCarti;
        this.nume = nume;
        this.idAutor = idAutor;
        this.anulPublicarii = anulPublicarii;
        imprumutata = false;
    }

    public static Integer getNrCarti() {
        return nrCarti;
    }

    public Integer getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(Integer idCarte) {
        this.idCarte = idCarte;
    }

    public String getNume() {
        return nume;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public String getAnulPublicarii() {
        return anulPublicarii;
    }

    public boolean isImprumutata() {
        return imprumutata;
    }

    public void setImprumutata(boolean imprumutata) {
        this.imprumutata = imprumutata;
    }

    @Override
    public String toString() {
        return  "idCarte=" + idCarte +
                ", nume='" + nume + '\'' +
                ", id-autor=" + idAutor +
                ", anulPublicarii=" + anulPublicarii +
                ", imprumutata=" + imprumutata +"\n";
    }
}

