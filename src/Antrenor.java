public class Antrenor extends Staff{

    private String Nationalitate;
    private String Agent;
    private String Licenta;
    private String Pozitie;

    public Antrenor(String nume, String prenume, String telefon, String email, Integer salariu, String nationalitate, String agent, String licenta, String pozitie) {
        super(nume, prenume, telefon, email, salariu);
        Nationalitate = nationalitate;
        Agent = agent;
        Licenta = licenta;
        Pozitie = pozitie;
    }

    public String getNationalitate() {
        return Nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        Nationalitate = nationalitate;
    }

    public String getAgent() {
        return Agent;
    }

    public void setAgent(String agent) {
        Agent = agent;
    }

    public String getLicenta() {
        return Licenta;
    }

    public void setLicenta(String licenta) {
        Licenta = licenta;
    }

    public String getPozitie() {
        return Pozitie;
    }

    public void setPozitie(String pozitie) {
        Pozitie = pozitie;
    }

    @Override
    public String toString() {
        return "Antrenor{" +
                "Nationalitate='" + Nationalitate + '\'' +
                ", Agent='" + Agent + '\'' +
                ", Licenta='" + Licenta + '\'' +
                ", Pozitie='" + Pozitie + '\'' +
                '}';
    }
}
