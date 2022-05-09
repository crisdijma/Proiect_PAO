public class Antrenor extends Staff{

    private String nationalitate;
    private String agent;
    private String licenta;
    private String pozitie;

    public Antrenor(String nume, String prenume, String telefon, String email, Integer salariu, String nationalitate, String agent, String licenta, String pozitie) {
        super(nume, prenume, telefon, email, salariu);
        this.nationalitate = nationalitate;
        this.agent = agent;
        this.licenta = licenta;
        this.pozitie = pozitie;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getLicenta() {
        return licenta;
    }

    public void setLicenta(String licenta) {
        this.licenta = licenta;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    @Override
    public String toString() {
        return "Antrenor{" +
                "Nume='" + getNume() + '\'' +
                ", Prenume='" + getPrenume() + '\'' +
                ", Telefon='" + getTelefon() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Salariu=" + getSalariu() +
                ", Nationalitate='" + nationalitate + '\'' +
                ", Agent=" + agent + '\'' +
                ", Licenta='" + licenta + '\'' +
                ", Pozitie='" + pozitie + '\'' +
                '}';
    }
}
