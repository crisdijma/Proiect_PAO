import java.util.List;

public interface BiletService {

    //Metoda care imi salveaza un bilet
    void save(Bilet bilet);

    //Metoda care imi sterge un bilet dat
    void delete(Bilet bilet);

    //Metoda care imi sterge un bilet dat prin sectorul acestuia
    void deleteBySector(String sector);

    //Metoda care imi returneaza pretul biletelor dintr-un anumit sector
    List<Bilet> getBySector(String sector);

    //Metoda care imi returneaza toate biletele sortate dupa pret
    List<Bilet> getAllSorted();

}
