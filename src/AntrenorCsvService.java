import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AntrenorCsvService implements AntrenorService{


    private final File antrenoriFile;

    public AntrenorCsvService() {
        this.antrenoriFile = new File("src/antrenori.csv");
        if(!antrenoriFile.exists()) {
            try {
                antrenoriFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(Antrenor antrenor) {
        FileWriter fileWriter= null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(antrenoriFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            boolean antrenorAlreadyExists = getAllSorted().stream()
                    .anyMatch(storedAntrenor -> storedAntrenor.getNume() == antrenor.getNume() &&
                            storedAntrenor.getPrenume().equals(antrenor.getPrenume()) &&
                            storedAntrenor.getTelefon().equals(antrenor.getTelefon()) &&
                            storedAntrenor.getEmail().equals(antrenor.getEmail()) &&
                            storedAntrenor.getSalariu().equals(antrenor.getSalariu()) &&
                            storedAntrenor.getNationalitate().equals(antrenor.getNationalitate()) &&
                            storedAntrenor.getAgent().equals(antrenor.getAgent()) &&
                            storedAntrenor.getLicenta().equals(antrenor.getLicenta()) &&
                            storedAntrenor.getPozitie().equals(antrenor.getPozitie())
                    );

            if(!antrenorAlreadyExists) {
                bufferedWriter.write(formatForCsv(antrenor));
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
    public void delete(Antrenor antrenorToDelete) {
        List<Antrenor> remainingAntrenori = getAllSorted().stream()
                .filter(storedAntrenor -> storedAntrenor.getNume() != antrenorToDelete.getNume() ||
                        !storedAntrenor.getPrenume().equals(antrenorToDelete.getPrenume()) ||
                        !storedAntrenor.getTelefon().equals(antrenorToDelete.getTelefon()) ||
                        !storedAntrenor.getEmail().equals(antrenorToDelete.getEmail()) ||
                        !storedAntrenor.getSalariu().equals(antrenorToDelete.getSalariu()) ||
                        !storedAntrenor.getNationalitate().equals(antrenorToDelete.getNationalitate()) ||
                        !storedAntrenor.getAgent().equals(antrenorToDelete.getAgent()) ||
                        !storedAntrenor.getLicenta().equals(antrenorToDelete.getLicenta()) ||
                        !storedAntrenor.getPozitie().equals(antrenorToDelete.getPozitie()))

                .collect(Collectors.toList());


        try(FileWriter fileWriter = new FileWriter(antrenoriFile, false)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Antrenor antrenor : remainingAntrenori) {
                bufferedWriter.write(formatForCsv(antrenor));
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {

        }
    }

    @Override
    public List<Antrenor> getByNume(String nume) {
        return null;
    }

    @Override
    public List<Antrenor> getAllSorted() {
        try {
            FileReader fileReader = new FileReader(antrenoriFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Antrenor> antrenori = bufferedReader.lines()
                    .map(line -> getAntrenorFromCsvLine(line))
                    .collect(Collectors.toList());

            antrenori.sort(Comparator.comparing(Antrenor::getNume));
            return antrenori;
        } catch (Exception e) {

        }

        return Collections.emptyList();
    }

    private Antrenor getAntrenorFromCsvLine(String line) {
        String[] values = line.split(",");
        Antrenor antrenor = new Antrenor(
                values[0],
                values[1],
                values[2],
                values[3],
                Integer.parseInt(values[4]),
                values[5],
                values[6],
                values[7],
                values[8]);

        return antrenor;
    }

    private String formatForCsv(Antrenor antrenor) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(antrenor.getNume());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getPrenume());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getTelefon());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getEmail());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getSalariu());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getNationalitate());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getAgent());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getLicenta());
        stringBuilder.append(",");
        stringBuilder.append(antrenor.getPozitie());


        return stringBuilder.toString();
    }
}
