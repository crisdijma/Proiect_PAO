
import java.util.List;
import java.util.Set;

public interface StadionService {

    //Metoda care imi salveaza un stadion
    void save(Stadion stadion);

    //Metoda care imi sterge un stadion dat
    void delete(Stadion stadion);

    //Metoda care imi returneaza toate stadioanele
    Set<Stadion> getAll();

    //Metoda care returneaza toate stadioanele care au peste o anumita capacitate de spectatori
    Set<Stadion> findStadiumAboveCapacity(int capacitate);

    //Metoda care afiseaza stadionul cu o anumita denumire
    Set<Stadion> getByDenumire(String denumire);

}
