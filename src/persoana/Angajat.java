package persoana;

import adresa.Adresa;

import java.util.Calendar;

public class Angajat extends Persoana {
    private static Integer nrAngajati = 0;
    private Integer idAngajat;
    private String CNP;
    private String nrTelefon;
    private Adresa adresa;

    public Angajat(String CNP, String prenume, String nume, String nrTelefon, Adresa adresa) {
        super(nume, prenume);
        idAngajat = ++nrAngajati;
        this.nrTelefon = nrTelefon;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return prenume + " " + nume + "," + nrTelefon +","+ adresa.toString() + "\n";
    }
}
