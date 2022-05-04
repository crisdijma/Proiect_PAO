public class Stadion {

    private String Denumire;
    private Integer Capacitate;
    private String Tip_Gazon;
    private String Adresa;

    public Stadion(String denumire, Integer capacitate, String tip_Gazon, String adresa) {
        Denumire = denumire;
        Capacitate = capacitate;
        Tip_Gazon = tip_Gazon;
        Adresa = adresa;
    }

    public String getDenumire() {
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public Integer getCapacitate() {
        return Capacitate;
    }

    public void setCapacitate(Integer capacitate) {
        Capacitate = capacitate;
    }

    public String getTip_Gazon() {
        return Tip_Gazon;
    }

    public void setTip_Gazon(String tip_Gazon) {
        Tip_Gazon = tip_Gazon;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    @Override
    public String toString() {
        return "Stadion{" +
                "Denumire='" + Denumire + '\'' +
                ", Capacitate=" + Capacitate +
                ", Tip_Gazon='" + Tip_Gazon + '\'' +
                ", Adresa='" + Adresa + '\'' +
                '}';
    }
}
