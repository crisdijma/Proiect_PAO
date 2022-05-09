public class Bilet {

    private String sector;
    private Integer pret;

    public Bilet(String sector, Integer pret) {
        this.sector = sector;
        this.pret = pret;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "sector='" + sector + '\'' +
                ", pret=" + pret +
                '}';
    }
}
