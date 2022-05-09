import java.util.Collections;

public class Jucator extends Staff{

    private String nationalitate;
    private Integer varsta;
    private Integer inaltime;
    private String pozitie;
    private String picior;

    public Jucator(String nume, String prenume, String telefon, String email, Integer salariu, String nationalitate, Integer varsta, Integer inaltime, String pozitie, String picior) {
        super(nume, prenume, telefon, email, salariu);
        this.nationalitate = nationalitate;
        this.varsta = varsta;
        this.inaltime = inaltime;
        this.pozitie = pozitie;
        this.picior = picior;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public Integer getInaltime() {
        return inaltime;
    }

    public void setInaltime(Integer inaltime) {
        this.inaltime = inaltime;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    public String getPicior() {
        return picior;
    }

    public void setPicior(String picior) {
        this.picior = picior;
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
                ", Nationalitate='" + nationalitate + '\'' +
                ", Varsta=" + varsta +
                ", Inaltime=" + inaltime +
                ", Pozitie='" + pozitie + '\'' +
                ", Picior='" + picior + '\'' +
                '}';
    }
}
