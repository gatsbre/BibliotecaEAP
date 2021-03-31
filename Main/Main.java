package Main;

import Biblioteca.*;
import java.util.*;

public class Main {
    public static void meniu()
    {
        System.out.println("DIYAR MERT DANIEL - GRUPA 253");
        System.out.println("BIBLIOTECA - ETAPA 1");
        System.out.println("\n Ce actiune doriti sa efectuati?");
        System.out.println("1.  Cautare scriere");
        System.out.println("2.  Stergere scriere");
        System.out.println("3.  Stergere client");
        System.out.println("4.  Cautare client");
        System.out.println("5.  Adaugare client");
        System.out.println("6.  Adaugare scrieri");
        System.out.println("7.  Afisare clienti");
        System.out.println("8.  Afisare scrieri");
        System.out.println("9.  Imprumutare scriere");
        System.out.println("10. Predare scriere");
        System.out.println("0.  Iesire.");
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Judeteana","Bulevardul Mamaia");
        Scanner scanner = new Scanner(System.in);
        int raspuns;

        do{
            meniu();
            System.out.println("\n");
            System.out.println("Raspuns: ");
            raspuns = scanner.nextInt();
            switch (raspuns) {

                case 1 -> {
                    System.out.println("1.  Cautare scriere\n");
                    Servicii.cautareScriere(biblioteca.getListaCarti());
                }
                case 2 -> {
                    String numeScriere;
                    System.out.println("2.  Stergere scriere");
                    System.out.println("Introduceti numele scrierii: ");
                    numeScriere = scanner.nextLine();
                    biblioteca.getListaCarti().removeIf(x -> x.getNume().equals(numeScriere));
                }
                case 3 -> {
                    String numeClient;
                    System.out.println("3.  Stergere client");
                    System.out.println("Introduceti numele clientului");
                    numeClient = scanner.nextLine();
                    String nrTelefon;
                    System.out.println("Introduceti numarul de telefon al clientului");
                    nrTelefon = scanner.next();
                    biblioteca.getListaClienti().removeIf(x -> (x.getNume().equals(numeClient) && x.getNrTelefon().equals(nrTelefon)));
                }
                case 4 -> {
                    System.out.println("4.  Cautare client");
                    Servicii.cautareClient(biblioteca.getListaClienti());
                }
                case 5 -> {
                    System.out.println("5.  Adaugare client");
                    biblioteca.getListaClienti().add(Servicii.adaugareClient());
                }
                case 6 -> {
                    System.out.println("6.  Adaugare carte");
                    biblioteca.getListaCarti().add(Servicii.adaugareScriere());
                }
                case 7 -> {
                    System.out.println("7.  Afisare clienti");
                    System.out.println(biblioteca.getListaClienti().toString());
                }
                case 8 -> {
                    System.out.println("8.  Afisare scrieri");
                    System.out.println(biblioteca.getListaCarti().toString());
                }
                case 9 -> {
                    System.out.println("9.  Imprumutare carte");
                    Servicii.imprumutaCarte(biblioteca.getListaClienti(),biblioteca.getListaCarti());
                }
                case 10 -> {
                    System.out.println("10. Predare carte");
                    Servicii.predareImprumuturi(biblioteca.getListaClienti());
                }
                default -> {
                    if(raspuns != 0)
                    System.out.println("Optiunea introdusa nu este valida");
                }

            }
        }while(raspuns!=0);
    }
}
