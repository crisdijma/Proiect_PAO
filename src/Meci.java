import java.util.List;
import java.util.Set;

public class Meci {
    private String adversar;
    private String competitie;
    private String data_Ora;
    private String scor;
    private Integer spectatori;

    private Stadion arena;
    private Set<Jucator> jucatori;
    private List<Eveniment> evenimente;
    private Set<Bilet> preturi_Bilete;

    public Meci(String adversar, String competitie, String data_Ora, String scor, Integer spectatori, Stadion arena, Set<Jucator> jucatori, List<Eveniment> evenimente, Set<Bilet> preturi_Bilete) {
        this.adversar = adversar;
        this.competitie = competitie;
        this.data_Ora = data_Ora;
        this.scor = scor;
        this.spectatori = spectatori;
        this.arena = arena;
        this.jucatori = jucatori;
        this.evenimente = evenimente;
        this.preturi_Bilete = preturi_Bilete;
    }

    public String getAdversar() {
        return adversar;
    }

    public void setAdversar(String adversar) {
        this.adversar = adversar;
    }

    public String getCompetitie() {
        return competitie;
    }

    public void setCompetitie(String competitie) {
        this.competitie = competitie;
    }

    public String getData_Ora() {
        return data_Ora;
    }

    public void setData_Ora(String data_Ora) {
        this.data_Ora = data_Ora;
    }

    public String getScor() {
        return scor;
    }

    public void setScor(String scor) {
        this.scor = scor;
    }

    public Integer getSpectatori() {
        return spectatori;
    }

    public void setSpectatori(Integer spectatori) {
        this.spectatori = spectatori;
    }

    public Stadion getArena() {
        return arena;
    }

    public void setArena(Stadion arena) {
        this.arena = arena;
    }

    public Set<Jucator> getJucatori() {
        return jucatori;
    }

    public void setJucatori(Set<Jucator> jucatori) {
        this.jucatori = jucatori;
    }

    public List<Eveniment> getEvenimente() {
        return evenimente;
    }

    public void setEvenimente(List<Eveniment> evenimente) {
        this.evenimente = evenimente;
    }

    public Set<Bilet> getPreturi_Bilete() {
        return preturi_Bilete;
    }

    public void setPreturi_Bilete(Set<Bilet> preturi_Bilete) {
        this.preturi_Bilete = preturi_Bilete;
    }

    @Override
    public String toString() {
        return "Meci{" +
                "adversar='" + adversar + '\'' +
                ", competitie='" + competitie + '\'' +
                ", data_Ora='" + data_Ora + '\'' +
                ", scor='" + scor + '\'' +
                ", spectatori=" + spectatori +
                ", arena=" + arena +
                ", jucatori=" + jucatori +
                ", evenimente=" + evenimente +
                ", preturi_Bilete=" + preturi_Bilete +
                '}';
    }
}
