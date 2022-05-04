import java.util.List;
import java.util.Set;

public class Meci {
    private String Adversar;
    private String Competitie;
    private String Data_Ora;
    private String Scor;
    private Integer Spectatori;

    private Stadion Arena;
    private Set<Jucator> Jucatori;
    private List<Eveniment> Evenimente;
    private Set<Bilet> Preturi_Bilete;

    public Meci(String adversar, String competitie, String data_Ora, String scor, Integer spectatori, Stadion arena, Set<Jucator> jucatori, List<Eveniment> evenimente, Set<Bilet> preturi_Bilete) {
        Adversar = adversar;
        Competitie = competitie;
        Data_Ora = data_Ora;
        Scor = scor;
        Spectatori = spectatori;
        Arena = arena;
        Jucatori = jucatori;
        Evenimente = evenimente;
        Preturi_Bilete = preturi_Bilete;
    }

    public String getAdversar() {
        return Adversar;
    }

    public void setAdversar(String adversar) {
        Adversar = adversar;
    }

    public String getCompetitie() {
        return Competitie;
    }

    public void setCompetitie(String competitie) {
        Competitie = competitie;
    }

    public String getData_Ora() {
        return Data_Ora;
    }

    public void setData_Ora(String data_Ora) {
        Data_Ora = data_Ora;
    }

    public String getScor() {
        return Scor;
    }

    public void setScor(String scor) {
        Scor = scor;
    }

    public Integer getSpectatori() {
        return Spectatori;
    }

    public void setSpectatori(Integer spectatori) {
        Spectatori = spectatori;
    }

    public Stadion getArena() {
        return Arena;
    }

    public void setArena(Stadion arena) {
        Arena = arena;
    }

    public Set<Jucator> getJucatori() {
        return Jucatori;
    }

    public void setJucatori(Set<Jucator> jucatori) {
        Jucatori = jucatori;
    }

    public List<Eveniment> getEvenimente() {
        return Evenimente;
    }

    public void setEvenimente(List<Eveniment> evenimente) {
        Evenimente = evenimente;
    }

    public Set<Bilet> getPreturi_Bilete() {
        return Preturi_Bilete;
    }

    public void setPreturi_Bilete(Set<Bilet> preturi_Bilete) {
        Preturi_Bilete = preturi_Bilete;
    }

    @Override
    public String toString() {
        return "Meci{" +
                "Adversar='" + Adversar + '\'' +
                ", Competitie='" + Competitie + '\'' +
                ", Data_Ora='" + Data_Ora + '\'' +
                ", Scor='" + Scor + '\'' +
                ", Spectatori=" + Spectatori +
                ", Arena=" + Arena +
                ", Jucatori=" + Jucatori +
                ", Evenimente=" + Evenimente +
                ", Preturi_Bilete=" + Preturi_Bilete +
                '}';
    }
}
