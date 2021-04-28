package main;
import biblioteca.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Servicii {

    public static void citireFisier(List <Scrieri> listaScrieri, List<Client> listaClienti)
    {
        try{
            File fisier_listaClienti = new File("src/biblioteca/clienti.csv");
            Scanner scanner = new Scanner(fisier_listaClienti);
            if(scanner.hasNextLine())
                scanner.nextLine();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] arg_of_Data = data.split(",");
                Client client = new Client(arg_of_Data[0],arg_of_Data[1],arg_of_Data[2]);
                listaClienti.add(client);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fisierul de citire nu a fost gasit");
            e.printStackTrace();
        }
        try{
            File fisier_listaCarti = new File("src/biblioteca/carti.csv");
            Scanner scanner = new Scanner(fisier_listaCarti);
            if(scanner.hasNextLine())
                scanner.nextLine();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] arg_of_Data = data.split(",");
                Editura editura = new Editura(arg_of_Data[3]);
                Autor autor = new Autor(arg_of_Data[1]);
                Carte carte = new Carte(arg_of_Data[0],autor,arg_of_Data[2],editura,arg_of_Data[4]);
                listaScrieri.add(carte);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fisierul de citire nu a fost gasit");
            e.printStackTrace();
        }
        try{
            File fisier_listaRevista = new File("src/biblioteca/revista.csv");
            Scanner scanner = new Scanner(fisier_listaRevista);
            if(scanner.hasNextLine())
                scanner.nextLine();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] arg_of_Data = data.split(",");
                Revista revista = new Revista(arg_of_Data[0],arg_of_Data[1],Integer.parseInt(arg_of_Data[2]));
                listaScrieri.add(revista);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fisierul de citire nu a fost gasit");
            e.printStackTrace();
        }

        try{
            File fisier_listaZiare = new File("src/biblioteca/ziar.csv");
            Scanner scanner = new Scanner(fisier_listaZiare);
            if(scanner.hasNextLine())
                scanner.nextLine();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] arg_of_Data = data.split(",");
                Ziar ziar = new Ziar(arg_of_Data[0],arg_of_Data[1],arg_of_Data[2]);
                listaScrieri.add(ziar);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fisierul de citire nu a fost gasit");
            e.printStackTrace();
        }


    }
    /*
    public static void scriereFisier(List <Scrieri> listaScrieri, List<Client> listaClienti) throws IOException {
        FileWriter scriereClient = new FileWriter("src/biblioteca/clienti.csv");
        scriereClient.write("nume, adresa, nr telefon\n");
        for(Client x : listaClienti)
            scriereClient.write(x.getNume()+","+x.getAdresa()+","+x.getNrTelefon()+"\n");
        scriereClient.close();
        Carte y1 = new Carte();
        Ziar y2 = new Ziar();
        Revista y3 = new Revista();
        FileWriter scriereCarte = new FileWriter("src/biblioteca/carti.csv");
        FileWriter scriereRevista = new FileWriter("src/biblioteca/revista.csv");
        FileWriter scriereZiar = new FileWriter("src/biblioteca/ziar.csv");
        scriereRevista.write("nume, anul publicarii, numar\n");
        scriereZiar.write("nume, anul publicarii, domeniu\n");
        scriereCarte.write("nume, autor, anul publicarii, editura, isbn\n");
        for(Scrieri x: listaScrieri)
            if(x.getClass() == y1.getClass())
            {

            }

    }
    */
    public static void cautareScriere(List<Scrieri> listaScrieri)
    {
        Scanner scanner = new Scanner(System.in);
        String sRaspuns;
        boolean gasit = false;
        System.out.println("Introduceti numele scrierii cautate: ");
        sRaspuns = scanner.nextLine();
        for(Scrieri x: listaScrieri)
        {
            if(x.getNume().equals(sRaspuns))
            {
                gasit = true;
                System.out.println(x.toString());
                break;
            }
        }
        if(!gasit)
            System.out.println("Scrierea cautatea nu a fost gasita in baza de date.\n");
    }

    public static void cautareClient(List<Client> listaClienti)
    {
        Scanner scanner = new Scanner(System.in);
        String sRaspuns, nrTelefon;
        boolean gasit = false;
        System.out.println("Introduceti numele clientului cautat: ");
        sRaspuns = scanner.nextLine();
        System.out.println("Introduceti numarul de telefon al clientului: ");
        nrTelefon = scanner.next();
        for(Client x: listaClienti)
            if(x.getNrTelefon().equals(nrTelefon) && x.getNume().equals(sRaspuns))
            {
                gasit = true;
                System.out.println(x.toString());
                break;
            }
        if(!gasit)
            System.out.println("Clientul nu se afla in baza de date.\n");
    }

    public static Client adaugareClient()
    {
        Scanner scanner = new Scanner(System.in);
        String nume, adresa, nrTelefon;
        System.out.println("Introduceti numele clientului: ");
        nume = scanner.nextLine();
        System.out.println("Introduceti adresa clientului: ");
        adresa = scanner.nextLine();
        System.out.println("Introduceti numarul de telefon al clientului");
        nrTelefon = scanner.next();
        return new Client(nume,adresa, nrTelefon);
    }

    public static Scrieri adaugareScriere()
    {
        Scanner scanner = new Scanner(System.in);
        String sRaspuns;
        Scrieri s = new Scrieri();
        System.out.println("Ce doriti sa adaugati? (carte/ziar/revista)");
        sRaspuns = scanner.nextLine();
        if(sRaspuns.equals("carte"))
        {
            String numeEditura, numeCarte,  anulPublicarii, ISBN;
            System.out.println("Numele editurii: ");
            numeEditura = scanner.nextLine();
            System.out.println("Numele autorului: ");
            String numeAutor = scanner.nextLine();
            System.out.println("Numele cartii: ");
            numeCarte = scanner.nextLine();
            System.out.println("Anul publicarii: ");
            anulPublicarii = scanner.next();
            System.out.println("ISBN-ul cartii: ");
            ISBN = scanner.next();
            Autor a = new Autor(numeAutor);
            Editura e = new Editura(numeEditura);
            s = new Carte(numeCarte,a,anulPublicarii,e,ISBN);


        }
        else if(sRaspuns.equals("ziar"))
        {
            String numeZiar, anulPublicarii,domeniu;
            System.out.println("Numele ziarului: ");
            numeZiar = scanner.nextLine();
            System.out.println("Anul publicarii: ");
            anulPublicarii = scanner.next();
            System.out.println("Domeniul ziarului: ");
            domeniu = scanner.nextLine();
            s = new Ziar(numeZiar,anulPublicarii,domeniu);
        }
        else if(sRaspuns.equals("revista"))
        {
            //public Revista(String nume, Autor autor, String anulPublicarii, Integer numar) {
            String numeRevista, anulPublicarii;
            Integer numar;
            System.out.println("Numele revistei: ");
            numeRevista = scanner.nextLine();
            System.out.println("Anul publicarii: ");
            anulPublicarii = scanner.next();
            System.out.println("Numarul revistei: ");
            numar = scanner.nextInt();
            s = new Revista(numeRevista,anulPublicarii,numar);
        }

        return s;
    }

    public static void imprumutaCarte(List<Client> listaClienti,List<Scrieri> listaScrieri)
    {
        Scanner scanner = new Scanner(System.in);
        String sRaspuns;

        boolean gasit = false;
        boolean imprumutat = false;
        Integer idClient;
        System.out.println("Introduceti id-ul clientului: ");
        String s = scanner.nextLine();
        idClient = Integer.parseInt(s);
        for(Client x: listaClienti)
            if(x.getIdAbonament().equals(idClient))
                if(x.getImprumuturi().size() > 3)
                    System.out.println("Trebuie sa predati o carte pentru a mai putea imprumuta");
                else {
                    System.out.println("Introduceti numele scrierii cautate: ");
                    sRaspuns = scanner.nextLine();
                    for (Scrieri y : listaScrieri) {
                        if (y.getNume().equals(sRaspuns)) {
                            gasit = true;
                            if (y.getImprumut())
                            {
                                imprumutat = true;
                                x.getImprumuturi().add(y);
                            }
                                break;
                        }
                    }
                    if (!gasit)
                        System.out.println("Produsul cautat nu a fost gasit in baza de date.\n");
                    else if(!imprumutat)
                        System.out.println("Toate cartile cu titlul ales sunt imprumutate");
                }
    }

    public static void predareImprumuturi(List<Client> listaClienti)
    {
        Scanner scanner = new Scanner(System.in);
        Integer idClient;
        boolean gasitInLista = false;
        System.out.println("Introduceti id-ul clientului: ");
        idClient = scanner.nextInt();
        for(Client x: listaClienti)
            if(x.getIdAbonament().equals(idClient))
            {
                System.out.println(x.getImprumuturi().toString());
                System.out.println("Introduceti titlul scrierii");
                String numeScriere = scanner.nextLine();
                for(Scrieri y: x.getImprumuturi())
                {
                    if(y.getNume().equals(numeScriere))
                    {
                        gasitInLista = true;
                        y.setImprumut(false);
                        x.getImprumuturi().remove(y);
                    }
                }
            }
        else System.out.println("Utilizatorul nu se afla in baza de date");
        if(!gasitInLista)
            System.out.println("Produsul nu se afla in lista dumneavoastra");
    }
}
