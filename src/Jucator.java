import java.util.Collections;

public class Jucator extends Staff{

    private String Nationalitate;
    private Integer Varsta;
    private Integer Inaltime;
    private String Pozitie;
    private String Picior;

    public Jucator(String nume, String prenume, String telefon, String email, Integer salariu, String nationalitate, Integer varsta, Integer inaltime, String pozitie, String picior) {
        super(nume, prenume, telefon, email, salariu);
        Nationalitate = nationalitate;
        Varsta = varsta;
        Inaltime = inaltime;
        Pozitie = pozitie;
        Picior = picior;
    }

    public String getNationalitate() {
        return Nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        Nationalitate = nationalitate;
    }

    public Integer getVarsta() {
        return Varsta;
    }

    public void setVarsta(Integer varsta) {
        Varsta = varsta;
    }

    public Integer getInaltime() {
        return Inaltime;
    }

    public void setInaltime(Integer inaltime) {
        Inaltime = inaltime;
    }

    public String getPozitie() {
        return Pozitie;
    }

    public void setPozitie(String pozitie) {
        Pozitie = pozitie;
    }

    public String getPicior() {
        return Picior;
    }

    public void setPicior(String picior) {
        Picior = picior;
    }

    public void copiere(Jucator j1){
        this.setNume(j1.getNume());
        this.setPrenume(j1.getPrenume());
        this.setEmail(j1.getEmail());
        this.setTelefon(j1.getTelefon());
        this.setSalariu(j1.getSalariu());
        this.setNationalitate(j1.getNationalitate());
        this.setInaltime(j1.getInaltime());
        this.setVarsta(j1.getVarsta());
        this.setPozitie(j1.getPozitie());
        this.setPicior(j1.getPicior());

    }

    @Override
    public String toString() {
        return "Jucator{" +
                "Nume='" + getNume() + '\'' +
                ", Prenume='" + getPrenume() + '\'' +
                ", Telefon='" + getTelefon() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Salariu=" + getSalariu() +
                ", Nationalitate='" + Nationalitate + '\'' +
                ", Varsta=" + Varsta +
                ", Inaltime=" + Inaltime +
                ", Pozitie='" + Pozitie + '\'' +
                ", Picior='" + Picior + '\'' +
                '}';
    }
}
