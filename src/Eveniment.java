public class Eveniment {

    //Un eveniment poate fi un cartonas(rosu,galben), un gol marcat, un penalty, un autogol, o schimbare

    private String event;
    private Integer minut;
    private String echipa;

    public Eveniment(String event, Integer minut, String echipa) {
        this.event = event;
        this.minut = minut;
        this.echipa = echipa;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getMinut() {
        return minut;
    }

    public void setMinut(Integer minut) {
        this.minut = minut;
    }

    public String getEchipa() {
        return echipa;
    }

    public void setEchipa(String echipa) {
        this.echipa = echipa;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "event='" + event + '\'' +
                ", minut=" + minut +
                ", echipa='" + echipa + '\'' +
                '}';
    }
}
