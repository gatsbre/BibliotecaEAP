package persoana;

import java.util.ArrayList;
import java.util.List;
import carte.Carte;

public class Persoana {
    protected String nume;
    protected String prenume;

    public Persoana(){}

    public Persoana(String prenume, String nume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume + " " + prenume;
    }

}
