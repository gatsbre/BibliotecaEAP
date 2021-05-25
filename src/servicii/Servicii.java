package servicii;

import abonament.Abonament;
import abonament.Imprumut;
import adresa.Adresa;
import carte.Carte;
import persoana.Angajat;
import persoana.Autor;
import persoana.Cititor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Servicii {
    public static void meniu()
    {
        System.out.println("DIYAR MERT DANIEL - GRUPA 253");
        System.out.println("BIBLIOTECA");
        System.out.println("\n Ce actiune doriti sa efectuati?");
        System.out.println("1.  Afisarea cartilor");
        System.out.println("2.  Cautare carte");
        System.out.println("3.  Cautare client");
        System.out.println("4.  Afisare carti imprumutate");
        System.out.println("5.  Predare carte");
        System.out.println("6.  Imprumutare carte");
        System.out.println("7.  Afisare cartilor imprumutate de un client");
        System.out.println("8.  Afisare detalii autor");
        System.out.println("9.  Adaugare client");
        System.out.println("10. Afisati angajati si detaliile acestora");
        System.out.println("0.  Iesire.");
    }

    public static void executareServicii() throws IllegalAccessException, IOException {

        ArrayList<Carte> listaCarti = new ArrayList<>();
        ArrayList<Angajat> listaAngajati = new ArrayList<>();
        ArrayList<Cititor> listaCititori = new ArrayList<>();
        ArrayList<Autor> listaAutori = new ArrayList<>();
        //Citire din CSV-uri
       CSVobject.readCarte(listaCarti);
       CSVobject.readClienti(listaCititori);
       CSVobject.readAngajati(listaAngajati);
       CSVobject.readAutori(listaAutori);

        Scanner scanner = new Scanner(System.in);
        int opt;
        meniu();
        Date data;
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String timestamp;
        do {

            System.out.println("\n");
            System.out.println("Optiunea aleasa: ");
            opt = scanner.nextInt();
            switch (opt)
            {
                case 1:
                    for(Carte x: listaCarti)
                        System.out.printf(x.toString());
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Afisarea cartilor",timestamp);
                    break;
                case 2:
                    System.out.println("Introduceti numele cartii:");
                    String numeCarte = scanner.next();
                    boolean gasitt = false;
                    for(Carte x: listaCarti)
                        if(numeCarte.equals(x.getNume()))
                            gasitt = true;

                       if(gasitt)
                            System.out.println("Cartea " + numeCarte + " se afla in biblioteca\n");
                        else
                            System.out.println("Cartea cautata nu se afla in biblioteca\n");
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Cautare carte",timestamp);
                    break;
                case 3:
                    System.out.println("Introduceti numele clientului cautat:");
                    String clientCNP = scanner.nextLine();
                    for(Cititor x: listaCititori)
                        if(x.getCNP() == clientCNP)
                            System.out.println("Clientul a fost gasit in baza de date.\n" + x.toString());
                        else
                            System.out.println("Clientul nu se afla in baza de date");
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Cautare client",timestamp);
                    break;
                case 4:
                    for(Carte x: listaCarti)
                        if(x.isImprumutata() == true)
                            System.out.println("Cartea " +x.getNume() +" este imprumutata si trebuie predata");
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Afisare carti imprumutate",timestamp);
                    break;
                case 5:
                    System.out.println("Introduceti CNP-ul clientului: ");
                    String cnpClient = scanner.nextLine();
                    boolean gasit = false;
                    for (Cititor x: listaCititori)
                        if(x.getCNP().equals(cnpClient))
                        {
                            System.out.println(x.getAbonament().toString());
                            System.out.println("\nCe carte doriti sa predati?");
                            Integer idImprumut = scanner.nextInt();
                            for(Imprumut y: x.getAbonament().getListaImprumuturi())
                                if(idImprumut == y.getNrImprumut())
                                {
                                    x.getAbonament().predaImprumut(idImprumut);
                                }
                                else System.out.println("numarul imprumutului nu este corect");

                        }
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Predare carte",timestamp);
                    break;
                case 6:
                for(Carte x: listaCarti)
                    if(x.isImprumutata()==false)
                    {
                        System.out.println("Cartea "+x.toString()+" poate fi imprumutata. Doriti sa o imprumutati? (da/nu)\n");
                        String raspuns = scanner.next();
                        if(raspuns.equals("da")) {
                            System.out.println("Introduceti id-ul abonamentului dvs:");
                            Integer idAbonament = scanner.nextInt();
                            for(Cititor y:listaCititori)
                                if(idAbonament == y.getAbonament().getIdAbonament())
                                {
                                    Imprumut imprumut = new Imprumut(x.getIdCarte());
                                    y.getAbonament().adaugaImprumut(imprumut);
                                    x.setImprumutata(true);
                                }
                                else System.out.println("id-ul introdus nu se afla in baza de date");
                        }

                    }
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Imprumutare carte",timestamp);
                break;
                case 7:
                    System.out.println("Introduceti CNP-ul clientului:");
                    String clientCNP2 = scanner.nextLine();
                    for(Cititor x: listaCititori)
                        if(x.getCNP().equals(clientCNP2))
                        {
                            for(Imprumut y:x.getAbonament().getListaImprumuturi())
                                for(Carte z: listaCarti)
                                    if(y.getIdCarte() == z.getIdCarte())
                                        System.out.println(z.toString());
                        }
                        else System.out.println("Clientul nu se afla in baza de date");
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Afisare cartilor imprumutate de un client",timestamp);
                    break;
                case 8:
                    for(Autor x:listaAutori)
                        System.out.println(x.toString());
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Afisare detalii autor",timestamp);
                    break;
                case 9:
                    System.out.println("Introduceti CNP-ul clientului");
                    String CNP = scanner.next();
                    Integer idAbonament=0;
                    for(Cititor x: listaCititori)
                    {if(x.getCNP().equals(CNP)) {
                            System.out.println("Exista deja un client cu acest CNP");
                            break;
                        }
                    idAbonament = x.getAbonament().getIdAbonament();
                    }
                    System.out.println("Introduceti numele clientului");
                    String nume = scanner.nextLine();
                    System.out.println("Introduceti prenumele clientului");
                    String prenume = scanner.nextLine();
                    System.out.println("Introduceti adresa clientului in urmatoarea ordine: strada, numar, localitate, judet\n");
                    String strada = scanner.nextLine();
                    String numar = scanner.next();
                    String localitate = scanner.nextLine();
                    String judet = scanner.nextLine();
                    System.out.println("Introduceti numarul de telefon al clientului:");
                    String nrTelefon = scanner.nextLine();
                    Adresa adresa = new Adresa(strada,numar,localitate,judet);
                    Abonament abonament = new Abonament(idAbonament+1);
                    Cititor cititor = new Cititor(prenume,nume,CNP,adresa,nrTelefon,abonament);
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Adaugare client",timestamp);
                    break;
                case 10:
                    for(Angajat x: listaAngajati)
                        System.out.println(x.toString());
                    data = new Date();
                    timestamp = formater.format(data);
                    adaugareAudit("Afisati angajati si detaliile acestora",timestamp);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiunea introdusa este invalida!");
            }
        }while(opt != 0);
    }
    public static void adaugareAudit(String numeActiune,String timestamp) throws IOException {

        FileWriter scriereAudit = new FileWriter("src/servicii/audit.csv", true);
        scriereAudit.write(numeActiune+"," + timestamp + "\n");
        scriereAudit.close();
    }

}
