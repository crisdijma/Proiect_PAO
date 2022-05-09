public class Staff {

    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private Integer salariu;

    public Staff(String nume, String prenume, String telefon, String email, Integer salariu) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.salariu = salariu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setSalariu(Integer salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
