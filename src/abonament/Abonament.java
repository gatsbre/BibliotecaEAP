package abonament;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Abonament {
    private static Integer nrAbonamente = 0;
    private Integer idAbonament;
    private List <Imprumut> listaImprumuturi = new ArrayList<Imprumut>();

    public Abonament(Integer idAbonament, List<Imprumut> listaImprumuturi) {
        this.idAbonament = idAbonament;
        this.listaImprumuturi = listaImprumuturi;
    }

    public Abonament(Integer idAbonament) {
        this.idAbonament = idAbonament;
    }

    public Integer getIdAbonament()
    {
        return idAbonament;
    }

    public void adaugaImprumut(Imprumut imprumut)
    {
        if(listaImprumuturi.size() < 3)
        {
            imprumut.setNrImprumut(listaImprumuturi.size()+1);
            listaImprumuturi.add(imprumut);
        }
        else System.out.println("Numarul de 3 imprumuturi a fost depasit. Pentru a imprumuta trebuie sa predati una dintre cartile imprumutate.\n");
    }

    public void predaImprumut(Integer nrImprumut)
    {
        boolean gasit = false;
        for(Imprumut x : listaImprumuturi)
            if(x.getNrImprumut() == nrImprumut)
            {
                gasit = true;
                listaImprumuturi.remove(x);
                break;
            }
        if(gasit == false)
            System.out.println("Imprumutul cu id-ul "+ nrImprumut +" nu exista");
    }

    public List<Imprumut> getListaImprumuturi() {
        return listaImprumuturi;
    }

    @Override
    public String toString() {
        return  "idAbonament=" + idAbonament +
                ", listaImprumuturi=" + listaImprumuturi+"\n";
    }
}