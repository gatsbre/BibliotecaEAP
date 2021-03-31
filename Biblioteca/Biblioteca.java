package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nume;
    private String adresa;
    private List <Scrieri> listaCarti = new ArrayList<Scrieri>();
    private List <Client> listaClienti = new ArrayList<Client>();

    public Biblioteca(){

    }

    public Biblioteca(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    public Biblioteca(String nume, String adresa, List<Scrieri> listaCarti, List<Client> clienti) {
        this.nume = nume;
        this.adresa = adresa;
        this.listaCarti = listaCarti;
        this.listaClienti = clienti;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Client> getListaClienti() {
        return listaClienti;
    }

    public void setListaClienti(List<Client> listaClienti) {
        this.listaClienti = listaClienti;
    }

    public List<Scrieri> getListaCarti() {
        return listaCarti;
    }

    public void setListaCarti(List<Scrieri> listaCarti) {
        this.listaCarti = listaCarti;
    }

    @Override
    public String toString() {
        return "Biblioteca " + nume + "\n" +
                "Adresa: " + adresa + "\n" +
                "Scrieri: "+ listaCarti.toString() + "\n" +
                "Clienti: "+ listaClienti.toString() +"\n";
    }
}
