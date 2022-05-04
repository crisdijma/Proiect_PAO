import groovyjarjarantlr4.v4.runtime.misc.Array2DHashSet;

import java.util.*;
import java.util.stream.Collectors;

public class StadionInMemoryService implements StadionService {

    Set<Stadion> statioane= new HashSet<>();

    @Override
    public void save(Stadion stadion) {
        statioane.add(stadion);
    }

    @Override
    public void delete(Stadion stadion) {
        statioane.remove(stadion);
    }

    @Override
    public Set<Stadion> getAll() {
        return  statioane;
    }

    @Override
    public Set<Stadion> findStadiumAboveCapacity(int capacitate) {
        Set<Stadion>stadioaneCapacitate = statioane.stream()
                .filter(stadion -> stadion.getCapacitate() > capacitate)
                .collect(Collectors.toSet());

        if(stadioaneCapacitate.size()==0) {
            return null;
        }

        return stadioaneCapacitate;
    }

    @Override
    public Set<Stadion> getByDenumire(String denumire) {
        Set<Stadion>stadionDenumire = statioane.stream()
                .filter(stadion -> stadion.getDenumire().equals(denumire))
                .collect(Collectors.toSet());

        return stadionDenumire;
    }
}
