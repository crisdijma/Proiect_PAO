import java.util.List;

public interface JucatorService {

    //Metoda care imi salveaza un jucator
    void save(Jucator jucator);

    //Metoda care imi sterge un jucator dat
    void delete(Jucator jucator);

    //Metoda care imi sterge jucatorul dat prin numele si prenumele acestuia
    void deleteByFullName(String nume, String prenume);

    //Metoda care imi modifica salariul tuturor jucatorilor care au peste un anumit salariu scazand cate 1000
    void updateAboveSalary(Integer salariu);

    //Metoda care imi returneaza jucatorii care au un anumit nume
    List<Jucator> getByNume(String nume);

    //Metoda care imi returneaza toti jucatorii sortati dupa nume
    List<Jucator> getAllSorted();

    //Metoda care returneaza toti jucatorii care au sub o anumita varsta
    List<Jucator> findPlayersUnder(int varsta);

    //Metoda care returneaza toti jucatorii c pot suta cu anumit picior
    List<Jucator> findPlayersByFoot(String picior);

}
