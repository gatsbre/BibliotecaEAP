package persoana;

import carte.Carte;

import java.util.Calendar;


public class Autor extends Persoana{
    private Integer idAutor;
    private String tara;

    public Autor(Integer idAutor,String prenume, String nume, String tara) {
        super(nume, prenume);
        this.tara = tara;
        this.idAutor = idAutor;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public String getTara() {
        return tara;
    }


    @Override
    public String toString() {
        return prenume + "," + nume + "," + tara + "\n";
    }
}
