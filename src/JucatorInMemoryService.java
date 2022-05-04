import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JucatorInMemoryService implements JucatorService{

    List<Jucator> jucatori = new ArrayList<>();

    @Override
    public void save(Jucator jucator) {
        jucatori.add(jucator);
    }


    @Override
    public void delete(Jucator jucator) {
        jucatori.remove(jucator);
    }

    @Override
    public void deleteByFullName(String nume, String prenume) {
        for(int i=0;i<jucatori.size();i++)
        {
            if(jucatori.get(i).getNume()==nume && jucatori.get(i).getPrenume()==prenume)
                jucatori.remove(i);
        }
    }

    @Override
    public void updateAboveSalary(Integer salariu) {
        for(int i=0;i<jucatori.size();i++) {
            Jucator jucator = new Jucator(null, null, null, null, null,null, null, null, null, null);
            if (jucatori.get(i).getSalariu() > salariu) {
                jucator.copiere(jucatori.get(i));
                jucator.setSalariu(jucatori.get(i).getSalariu()-1000);
                jucatori.set(i, jucator);
            }
        }
    }

    @Override
    public List<Jucator> getByNume(String nume) {
        List<Jucator>jucatoriNume = jucatori.stream()
                .filter(jucator -> jucator.getNume().equals(nume))
                .collect(Collectors.toList());

        if(jucatoriNume.size()==0) {
            return null;
        }

        return jucatoriNume;

    }

    @Override
    public List<Jucator> getAllSorted() {
        jucatori.sort(Comparator.comparing(Jucator::getNume));
        return  jucatori;
    }

    @Override
    public List<Jucator> findPlayersUnder(int varsta) {
        List<Jucator>jucatoriVarsta = jucatori.stream()
                .filter(jucator -> jucator.getVarsta() < varsta)
                .collect(Collectors.toList());

        if(jucatoriVarsta.size()==0) {
            return null;
        }

        return jucatoriVarsta;
    }

    public List<Jucator> findPlayersByFoot(String picior){
        List<Jucator>jucatoriPicior = jucatori.stream()
                .filter(jucator -> jucator.getPicior() == picior || jucator.getPicior() == "Ambele")
                .collect(Collectors.toList());

        if(jucatoriPicior.size()==0) {
            return null;
        }

        return jucatoriPicior;
    }

}
