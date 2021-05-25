package adresa;

public class Adresa {
    private String strada;
    private String oras;
    private String judet;
    private String numar;

    public Adresa(String strada, String numar, String oras, String judet) {
        this.strada = strada;
        this.oras = oras;
        this.judet = judet;
        this.numar = numar;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "strada " + strada +", numarul "+numar + ",localitatea "+oras +", judetul" +judet + "\n";
    }
}
