package servicii;

import abonament.Abonament;
import adresa.Adresa;
import carte.Carte;
import persoana.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CSVobject {

    public static void readCarte(List<Carte> listaCarti) throws InstantiationError, IllegalAccessException{
    try{
        File fisier_listaCarti=new File("src/carte/carte.csv");
        Scanner scanner = new Scanner(fisier_listaCarti);
        if(scanner.hasNextLine())
            scanner.nextLine();
        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            String[] arg_of_Data = data.split(",");
            Carte carte = new Carte(arg_of_Data[0],Integer.parseInt(arg_of_Data[1]),arg_of_Data[2]);
            listaCarti.add(carte);
        }
        scanner.close();
    }
    catch (FileNotFoundException e){
        System.out.println("Fisierul de citire nu a fost gasit");
        e.printStackTrace();
    }

        }
    public static void readAutori(List<Autor> listaAutori) throws InstantiationError, IllegalAccessException{
        try{
            File fisier_listaAutori=new File("src/persoana/autori.csv");
            Scanner scanner = new Scanner(fisier_listaAutori);
            if(scanner.hasNextLine())
                scanner.nextLine();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] arg_of_Data = data.split(",");
                Autor autor = new Autor(Integer.parseInt(arg_of_Data[0]),arg_of_Data[1],arg_of_Data[2],arg_of_Data[3]);
                listaAutori.add(autor);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fisierul de citire nu a fost gasit");
            e.printStackTrace();
        }

    }
    public static void readClienti(List<Cititor> listaClienti) throws InstantiationError, IllegalAccessException {
        try {
            File fisier_listaClienti = new File("src/persoana/clienti.csv");
            Scanner scanner = new Scanner(fisier_listaClienti);
            if (scanner.hasNextLine())
                scanner.nextLine();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] arg_of_Data = data.split(",");
                Adresa adresa = new Adresa(arg_of_Data[4], arg_of_Data[5], arg_of_Data[6], arg_of_Data[7]);
                Abonament abonament = new Abonament(Integer.parseInt(arg_of_Data[0]));
                Cititor cititor = new Cititor(arg_of_Data[1], arg_of_Data[2], arg_of_Data[3], adresa, arg_of_Data[7], abonament);
                listaClienti.add(cititor);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul de citire nu a fost gasit");
            e.printStackTrace();
        }
    }
    public static void readAngajati(List<Angajat> listaAngajati) throws InstantiationError, IllegalAccessException{
        try{
            File fisier_listaAngajati=new File("src/persoana/angajati.csv");
            Scanner scanner = new Scanner(fisier_listaAngajati);
            if(scanner.hasNextLine())
                scanner.nextLine();
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] arg_of_Data = data.split(",");
                Adresa adresa = new Adresa(arg_of_Data[4],arg_of_Data[5],arg_of_Data[6],arg_of_Data[7]);
                Angajat angajat = new Angajat(arg_of_Data[0],arg_of_Data[1],arg_of_Data[2],arg_of_Data[3],adresa);
                listaAngajati.add(angajat);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fisierul de citire nu a fost gasit");
            e.printStackTrace();
        }
    }
}
