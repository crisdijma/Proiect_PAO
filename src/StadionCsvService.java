import groovyjarjarantlr4.v4.runtime.misc.Array2DHashSet;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StadionCsvService implements StadionService {

    private final File stadioaneFile;

    public StadionCsvService() {
        this.stadioaneFile = new File("src/stadioane.csv");
        if(!stadioaneFile.exists()) {
            try {
                stadioaneFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(Stadion stadion) {
        FileWriter fileWriter= null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(stadioaneFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            boolean stadionAlreadyExists = getAll().stream()
                    .anyMatch(storedStadion -> storedStadion.getDenumire() == stadion.getDenumire() &&
                            storedStadion.getCapacitate().equals(stadion.getCapacitate()) &&
                            storedStadion.getTip_Gazon().equals(stadion.getTip_Gazon()) &&
                            storedStadion.getAdresa().equals(stadion.getAdresa())
                    );

            if(!stadionAlreadyExists) {
                bufferedWriter.write(formatForCsv(stadion));
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                }
            }

            if(bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Override
    public void delete(Stadion stadionToDelete) {
        Set<Stadion> remainingStadioane = getAll().stream()
                .filter(storedStadion -> storedStadion.getDenumire() != stadionToDelete.getDenumire() ||
                        !storedStadion.getCapacitate().equals(stadionToDelete.getCapacitate()) ||
                        !storedStadion.getTip_Gazon().equals(stadionToDelete.getTip_Gazon()) ||
                        !storedStadion.getAdresa().equals(stadionToDelete.getAdresa()))
                .collect(Collectors.toSet());


        try(FileWriter fileWriter = new FileWriter(stadioaneFile, false)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Stadion stadion : remainingStadioane) {
                bufferedWriter.write(formatForCsv(stadion));
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {

        }
    }

    @Override
    public Set<Stadion> getAll() {
        try {
            FileReader fileReader = new FileReader(stadioaneFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Set<Stadion> stadioane = bufferedReader.lines()
                    .map(line -> getStadioaneFromCsvLine(line))
                    .collect(Collectors.toSet());

            return stadioane;
        } catch (Exception e) {

        }

        return Collections.emptySet();
    }


    @Override
    public Set<Stadion> findStadiumAboveCapacity(int capacitate) {

        try {
            FileReader fileReader = new FileReader(stadioaneFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Set<Stadion> stadioane = bufferedReader.lines()
                    .map(line -> getStadioaneFromCsvLine(line))
                    .filter(stadion -> stadion.getCapacitate() > capacitate)
                    .collect(Collectors.toSet());

            return stadioane;
        } catch (Exception e) {

        }

        return Collections.emptySet();
    }

    @Override
    public Set<Stadion> getByDenumire(String denumire) {


        try {
            FileReader fileReader = new FileReader(stadioaneFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Set<Stadion> stadioane = bufferedReader.lines()
                    .map(line -> getStadioaneFromCsvLine(line))
                    .filter(stadion -> stadion.getDenumire().equals(denumire))
                    .collect(Collectors.toSet());

            return stadioane;
        } catch (Exception e) {

        }

        return Collections.emptySet();
    }

    private Stadion getStadioaneFromCsvLine(String line) {
        String[] values = line.split(",");
        Stadion stadion = new Stadion(
                values[0],
                Integer.parseInt(values[1]),
                values[2],
                values[3]);

        return stadion;
    }

    private String formatForCsv(Stadion stadion) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stadion.getDenumire());
        stringBuilder.append(",");
        stringBuilder.append(stadion.getCapacitate());
        stringBuilder.append(",");
        stringBuilder.append(stadion.getTip_Gazon());
        stringBuilder.append(",");
        stringBuilder.append(stadion.getAdresa());
        return stringBuilder.toString();
    }
}
