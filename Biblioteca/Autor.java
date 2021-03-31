package Biblioteca;

public class Autor {
    private String nume;

    public Autor(){

    }

    public Autor(String nume)
    {
        this.nume = nume;
    }

    public String getNume()
    {
        return this.nume;
    }

    @Override
    public String toString() {
        return nume;
    }
}
