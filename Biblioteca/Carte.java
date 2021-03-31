package Biblioteca;

import java.util.Date;

public class Carte extends Scrieri{
    private Editura editura;
    private String ISBN;
    private Autor autor;

    public Carte(){

    }

    public Carte(String nume, Autor autor, String anulPublicarii, Editura editura, String ISBN) {
        super(nume, anulPublicarii);
        this.editura = editura;
        this.ISBN = ISBN;
        this.autor = autor;
    }

    public Editura getEditura() {
        return editura;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nume: " + nume + "\n" +
                "Autor: " + autor.toString() +"\n" +
                "Anul publicarii: " + anulPublicarii + "\n" +
                "ISBN: " + ISBN + "\n" +
                 editura.toString() +"\n" +
                "Imprumutata: " + imprumut + "\n";
    }
}
