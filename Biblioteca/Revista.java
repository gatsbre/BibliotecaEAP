package Biblioteca;

import java.util.Date;

public class Revista extends Scrieri{
    private Integer numar;

    public Revista(){

    }

    public Revista(String nume, String anulPublicarii, Integer numar) {
        super(nume, anulPublicarii);
        this.numar = numar;
    }

    public Integer getNumar() {
        return numar;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nume: " + nume + "\n" +
                "Anul publicarii: " + anulPublicarii + "\n" +
                "Numarul: " + numar + "\n" +
                "Imprumutata: " + imprumut + "\n";
    }
}
