import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class JucatoriCsvService implements JucatorService{
    private final File jucatoriFile;

    public JucatoriCsvService() {
        this.jucatoriFile = new File("src/jucatori.csv");
        if(!jucatoriFile.exists()) {
            try {
                jucatoriFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(Jucator jucator) {
        FileWriter fileWriter= null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(jucatoriFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            boolean jucatorAlreadyExists = getAllSorted().stream()
                    .anyMatch(storedJucator -> storedJucator.getNume() == jucator.getNume() &&
                            storedJucator.getPrenume().equals(jucator.getPrenume()) &&
                            storedJucator.getTelefon().equals(jucator.getTelefon()) &&
                            storedJucator.getEmail().equals(jucator.getEmail()) &&
                            storedJucator.getSalariu().equals(jucator.getSalariu()) &&
                            storedJucator.getNationalitate().equals(jucator.getNationalitate()) &&
                            storedJucator.getVarsta().equals(jucator.getVarsta()) &&
                            storedJucator.getInaltime().equals(jucator.getInaltime()) &&
                            storedJucator.getPozitie().equals(jucator.getPozitie()) &&
                            storedJucator.getPicior().equals(jucator.getPicior())
                    );

            if(!jucatorAlreadyExists) {
                bufferedWriter.write(formatForCsv(jucator));
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
    public void delete(Jucator jucatorToDelete) {
        List<Jucator> remainingJucatori = getAllSorted().stream()
                .filter(storedJucator -> storedJucator.getNume() != jucatorToDelete.getNume() ||
                        !storedJucator.getPrenume().equals(jucatorToDelete.getPrenume()) ||
                        !storedJucator.getTelefon().equals(jucatorToDelete.getTelefon()) ||
                        !storedJucator.getEmail().equals(jucatorToDelete.getEmail()) ||
                        !storedJucator.getSalariu().equals(jucatorToDelete.getSalariu()) ||
                        !storedJucator.getNationalitate().equals(jucatorToDelete.getNationalitate()) ||
                        !storedJucator.getVarsta().equals(jucatorToDelete.getVarsta()) ||
                        !storedJucator.getInaltime().equals(jucatorToDelete.getInaltime()) ||
                        !storedJucator.getPozitie().equals(jucatorToDelete.getPozitie()) ||
                        !storedJucator.getPicior().equals(jucatorToDelete.getPicior()))

                .collect(Collectors.toList());


        try(FileWriter fileWriter = new FileWriter(jucatoriFile, false)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Jucator jucator : remainingJucatori) {
                bufferedWriter.write(formatForCsv(jucator));
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {

        }
    }


    @Override
    public void deleteByFullName(String nume, String prenume) {

    }

    @Override
    public void updateAboveSalary(Integer salariu) {

    }

    @Override
    public List<Jucator> getByNume(String nume) {
        return null;
    }

    @Override
    public List<Jucator> getAllSorted() {
        try {
            FileReader fileReader = new FileReader(jucatoriFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Jucator> jucatori = bufferedReader.lines()
                    .map(line -> getJucatorFromCsvLine(line))
                    .collect(Collectors.toList());

            jucatori.sort(Comparator.comparing(Jucator::getNume));
            return jucatori;
        } catch (Exception e) {

        }

        return Collections.emptyList();
    }

    private Jucator getJucatorFromCsvLine(String line) {
        String[] values = line.split(",");
        Jucator jucator = new Jucator(
                values[0],
                values[1],
                values[2],
                values[3],
                Integer.parseInt(values[4]),
                values[5],
                Integer.parseInt(values[6]),
                Integer.parseInt(values[7]),
                values[8],
                values[9]);

        return jucator;
    }


    @Override
    public List<Jucator> findPlayersUnder(int varsta) {
        try {
            FileReader fileReader = new FileReader(jucatoriFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Jucator> jucatori = bufferedReader.lines()
                    .map(line -> getJucatorFromCsvLine(line))
                    .filter(jucator -> jucator.getVarsta() < varsta)
                    .collect(Collectors.toList());

            if(jucatori.size()==0) {
                return Collections.emptyList();
            }
            return jucatori;
        } catch (Exception e) {

        }

        return Collections.emptyList();
    }

    @Override
    public List<Jucator> findPlayersByFoot(String picior) {
        try {
            FileReader fileReader = new FileReader(jucatoriFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Jucator> jucatori = bufferedReader.lines()
                    .map(line -> getJucatorFromCsvLine(line))
                    .filter(jucator -> jucator.getPicior() == picior || jucator.getPicior() == "Ambele")
                    .collect(Collectors.toList());

            if(jucatori.size()==0) {
                return Collections.emptyList();
            }
            return jucatori;
        } catch (Exception e) {

        }

        return Collections.emptyList();
    }

    private String formatForCsv(Jucator jucator) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jucator.getNume());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getPrenume());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getTelefon());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getEmail());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getSalariu());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getNationalitate());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getVarsta());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getInaltime());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getPozitie());
        stringBuilder.append(",");
        stringBuilder.append(jucator.getPicior());

        return stringBuilder.toString();
    }
}
