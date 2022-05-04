public class Eveniment {

    //Un eveniment poate fi un cartonas(rosu,galben), un gol marcat, un penalty, un autogol, o schimbare

    private String Event;
    private Integer Minut;
    private String Echipa;

    public Eveniment(String event, Integer minut, String echipa) {
        Event = event;
        Minut = minut;
        Echipa = echipa;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public Integer getMinut() {
        return Minut;
    }

    public void setMinut(Integer minut) {
        Minut = minut;
    }

    public String getEchipa() {
        return Echipa;
    }

    public void setEchipa(String echipa) {
        Echipa = echipa;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "Event='" + Event + '\'' +
                ", Minut=" + Minut +
                ", Echipa='" + Echipa + '\'' +
                '}';
    }
}
