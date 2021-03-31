package Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static Integer nrConturi = 0;
    private String nume;
    private String adresa;
    private String nrTelefon;
    private Integer idAbonament;
    private List<Scrieri> imprumuturi = new ArrayList<Scrieri>();

    public Client(){

    }

    public Client(String nume, String adresa, String nrTelefon) {
        this.nume = nume;
        this.adresa = adresa;
        this.nrTelefon = nrTelefon;
        idAbonament = ++ nrConturi;
    }

    public Client(String nume, String adresa, String nrTelefon, List<Scrieri> imprumuturi) {
        this.nume = nume;
        this.adresa = adresa;
        this.nrTelefon = nrTelefon;
        idAbonament = ++ nrConturi;
        this.imprumuturi = imprumuturi;
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

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public Integer getIdAbonament() {
        return idAbonament;
    }

    public List<Scrieri> getImprumuturi() {
        return imprumuturi;
    }

    public void setImprumuturi(List<Scrieri> imprumuturi) {
        this.imprumuturi = imprumuturi;
    }

    @Override
    public String toString() {
        return  "ID: " + idAbonament + "\n" +
                "Nume:" + nume + "\n" +
                "Adresa: " + adresa + "\n" +
                "Nr telefon: " + nrTelefon + "\n" +
                "Imprumuturi:" + imprumuturi.toString() + "\n";
    }

    /*
    public void adaugaImprumut(Scrieri scriere)
    {
        if(imprumuturi.size() > 3)
        {
            System.out.println("Clientul are deja 3 imprumuturi");
        }
        else
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ce doriti sa imprumutati? (carte/revista)");
            String raspuns = scanner.next();
            if(raspuns.equals("carte"))
            {
                System.out.println("Doriti sa cautati in functie de nume sau ISBN?");
                raspuns = scanner.next();
                if(raspuns.equals("nume"))
                {

                }
                else if(raspuns.equals("ISBN"))
                {

                }
            }
            else if(raspuns.equals("revista"))
            {
                System.out.println("Numele revistei dorite:");
                String numar;
                raspuns = scanner.next();
                System.out.println("Numarul dorit:");
                numar = scanner.next();
            }
        }
    }

     */
}
