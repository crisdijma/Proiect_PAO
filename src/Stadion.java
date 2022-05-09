public class Stadion implements Comparable<Stadion>{

    private String denumire;
    private Integer capacitate;
    private String tip_gazon;
    private String adresa;

    public Stadion(String denumire, Integer capacitate, String tip_gazon, String adresa) {
        this.denumire = denumire;
        this.capacitate = capacitate;
        this.tip_gazon = tip_gazon;
        this.adresa = adresa;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Integer getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(Integer capacitate) {
        this.capacitate = capacitate;
    }

    public String getTip_Gazon() {
        return tip_gazon;
    }

    public void setTip_Gazon(String tip_gazon) {
        this.tip_gazon = tip_gazon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Stadion{" +
                "denumire='" + denumire + '\'' +
                ", capacitate=" + capacitate +
                ", tip_gazon='" + tip_gazon + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }

// Rescriere metoda de comparare pentru a putea utiliza tipul de colectie TreeSet in StadionInMemoryService
// Sortarea intre stadioane se va face in functie de capacitatea acestora
    @Override
    public int compareTo(Stadion c) {
        if (capacitate > c.capacitate) {
            return 1;
        }
        else if (capacitate < c.capacitate) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
