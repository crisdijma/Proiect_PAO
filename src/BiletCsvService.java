import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BiletCsvService implements BiletService{
    private final File bileteFile;

    public BiletCsvService() {
        this.bileteFile = new File("src/bilete.csv");
        if(!bileteFile.exists()) {
            try {
                bileteFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(Bilet bilet) {
        FileWriter fileWriter= null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(bileteFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            boolean biletAlreadyExists = getAllSorted().stream()
                    .anyMatch(storedBilet -> storedBilet.getSector() == bilet.getSector() &&
                            storedBilet.getPret().equals(bilet.getPret())
                    );

            if(!biletAlreadyExists) {
                bufferedWriter.write(formatForCsv(bilet));
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

    private Bilet getBileteFromCsvLine(String line) {
        String[] values = line.split(",");
        Bilet bilet = new Bilet(
                values[0],
                Integer.parseInt(values[1]));

        return bilet;
    }

    private String formatForCsv(Bilet bilet) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bilet.getSector());
        stringBuilder.append(",");
        stringBuilder.append(bilet.getPret());
        return stringBuilder.toString();
    }

    @Override
    public void delete(Bilet biletToDelete) {
        List<Bilet> remainingBilete = getAllSorted().stream()
                .filter(storedBilet -> storedBilet.getSector() != biletToDelete.getSector() ||
                        !storedBilet.getPret().equals(biletToDelete.getPret()))
                .collect(Collectors.toList());


        try(FileWriter fileWriter = new FileWriter(bileteFile, false)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Bilet bilet : remainingBilete) {
                bufferedWriter.write(formatForCsv(bilet));
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {

        }
    }

    @Override
    public void deleteBySector(String sector) {

        List<Bilet> remainingBilete = getAllSorted().stream()
                .filter(storedBilet -> storedBilet.getSector() != sector)
                .collect(Collectors.toList());


        try(FileWriter fileWriter = new FileWriter(bileteFile, false)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Bilet bilet : remainingBilete) {
                bufferedWriter.write(formatForCsv(bilet));
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {

        }

    }

    @Override
    public List<Bilet> getBySector(String sector) {
        try {
            FileReader fileReader = new FileReader(bileteFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Bilet> bilete = bufferedReader.lines()
                    .map(line -> getBileteFromCsvLine(line))
                    .filter(bilet -> bilet.getSector().equals(sector))
                    .collect(Collectors.toList());

            return bilete;
        } catch (Exception e) {

        }

        return Collections.emptyList();
    }

    @Override
    public List<Bilet> getAllSorted() {
        try {
            FileReader fileReader = new FileReader(bileteFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Bilet> bilete = bufferedReader.lines()
                    .map(line -> getBileteFromCsvLine(line))
                    .collect(Collectors.toList());

            bilete.sort(Comparator.comparing(Bilet::getPret));
            return bilete;
        } catch (Exception e) {

        }

        return Collections.emptyList();
    }
}
