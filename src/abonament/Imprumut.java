package abonament;

import carte.Carte;

import java.util.Calendar;

public class Imprumut{
    private static Integer nrImprumuturi =0;
    private Integer nrImprumut;
    private Integer idCarte;


    public Imprumut(Integer idCarte) {
        this.nrImprumut = ++nrImprumuturi;
        this.idCarte = idCarte;

    }

    public Integer getNrImprumut() {
        return nrImprumut;
    }

    public void setNrImprumut(Integer nrImprumut) {
        this.nrImprumut = nrImprumut;
    }

    public Integer getIdCarte() {
        return idCarte;
    }


    @Override
    public String toString() {
        return nrImprumut + " " + idCarte + "\n";
    }
}
