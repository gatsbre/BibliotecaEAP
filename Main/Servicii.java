package Main;
import Biblioteca.*;

import java.util.List;
import java.util.Scanner;

public class Servicii {

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
