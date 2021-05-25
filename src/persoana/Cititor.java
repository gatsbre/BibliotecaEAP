package persoana;

import adresa.Adresa;
import abonament.Abonament;

public class Cititor extends Persoana{
    private String CNP;
    private Adresa adresa;
    private String nrTelefon;
    private Abonament abonament;

    public Cititor(String prenume, String nume, String CNP, Adresa adresa, String nrTelefon,Abonament abonament) {
        super(nume, prenume);
        this.CNP = CNP;
        this.adresa = adresa;
        this.nrTelefon = nrTelefon;
        this.abonament = abonament;
    }

    public String getCNP()
    {
        return CNP;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public Abonament getAbonament() {
        return abonament;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public void setAbonament(Abonament abonament) {
        this.abonament = abonament;
    }

    @Override
    public String toString() {
        return "CNP='" + CNP + '\'' +
                ", adresa=" + adresa.toString() +
                ", nrTelefon='" + nrTelefon + '\'' +
                ", abonament=" + abonament +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\n';

    }
}
