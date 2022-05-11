import java.util.List;

public interface AntrenorService {

    //Metoda care imi salveaza un antrenor
    void save(Antrenor antrenor);

    //Metoda care imi sterge un antrenor dat
    void delete(Antrenor antrenor);

    //Metoda care imi returneaza antrenorii care au un anumit nume
    List<Antrenor> getByNume(String nume);

    //Metoda care imi returneaza toti antrenorii sortati dupa nume
    List<Antrenor> getAllSorted();

}