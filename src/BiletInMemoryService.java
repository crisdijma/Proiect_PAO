import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BiletInMemoryService implements BiletService{


    List<Bilet> bilete = new ArrayList<>();

    @Override
    public void save(Bilet bilet) {
        bilete.add(bilet);
    }

    @Override
    public void delete(Bilet bilet) {
        bilete.remove(bilet);
    }

    @Override
    public void deleteBySector(String sector) {
        for(int i=0;i<bilete.size();i++)
        {
            if(bilete.get(i).getSector()==sector)
                bilete.remove(i);
        }
    }

    @Override
    public List<Bilet> getBySector(String sector) {
        List<Bilet>biletSector = bilete.stream()
                .filter(bilet -> bilet.getSector().equals(sector))
                .collect(Collectors.toList());

        if(biletSector.size()==0) {
            return null;
        }

        return biletSector;
    }

    @Override
    public List<Bilet> getAllSorted() {
            bilete.sort(Comparator.comparing(Bilet::getPret));
            return  bilete;
    }
}
