public class Bilet {

    private String Sector;
    private Integer Pret;

    public Bilet(String sector, Integer pret) {
        Sector = sector;
        Pret = pret;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public Integer getPret() {
        return Pret;
    }

    public void setPret(Integer pret) {
        Pret = pret;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "Sector='" + Sector + '\'' +
                ", Pret=" + Pret +
                '}';
    }
}
