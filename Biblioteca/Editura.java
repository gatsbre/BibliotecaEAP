package Biblioteca;

public class Editura {
    private String nume;

    public Editura()
    {
    }

    public Editura(String n)
    {
        this.nume = n;
    }

    public String getNume()
    {
        return this.nume;
    }

    public void setNume(String n)
    {
        this.nume = n;
    }

    @Override
    public String toString() {
        return "Editura " + nume;
    }
}


