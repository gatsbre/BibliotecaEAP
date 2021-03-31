package Biblioteca;

public class Ziar extends Scrieri{
    private String domeniu;

    public Ziar(){

    }

    public Ziar(String nume, String anulPublicarii, String domeniu) {
        super(nume, anulPublicarii);
        this.domeniu = domeniu;
    }

    public String getDomeniu()
    {
        return this.domeniu;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nume: " + nume + "\n" +
                "Anul publicarii: " + anulPublicarii + "\n" +
                "Imprumutata: " + imprumut +"\n";
    }
}
