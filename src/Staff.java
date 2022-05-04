public class Staff {

    private String Nume;
    private String Prenume;
    private String Telefon;
    private String Email;
    private Integer Salariu;

    public Staff(String nume, String prenume, String telefon, String email, Integer salariu) {
        Nume = nume;
        Prenume = prenume;
        Telefon = telefon;
        Email = email;
        Salariu = salariu;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getSalariu(){
        return Salariu;
    }

    public void setSalariu(Integer salariu){
        Salariu = salariu;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "Nume='" + Nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
