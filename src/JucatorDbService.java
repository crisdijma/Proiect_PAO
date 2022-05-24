import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JucatorDbService implements JucatorService{

    private Connection connection;

    public JucatorDbService() throws SQLException {
        this.connection = DbConnection.getInstance();
    }


    @Override
    public void save(Jucator jucator) {

        String query = "insert into jucator values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, jucator.getNume());
            preparedStatement.setString(2, jucator.getPrenume());
            preparedStatement.setString(3, jucator.getTelefon());
            preparedStatement.setString(4, jucator.getEmail());
            preparedStatement.setInt(5, jucator.getSalariu());
            preparedStatement.setString(6, jucator.getNationalitate());
            preparedStatement.setInt(7, jucator.getVarsta());
            preparedStatement.setInt(8, jucator.getInaltime());
            preparedStatement.setString(9, jucator.getPozitie());
            preparedStatement.setString(10, jucator.getPicior());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Jucator jucator) {

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

        List<Jucator> jucatori = new ArrayList<>();
        String query = "select * from jucator";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                // citesc atributele pt fiecare record intors de select
                String nume = resultSet.getString(2);
                String prenume = resultSet.getString("prenume");
                String telefon = resultSet.getString("telefon");
                String email = resultSet.getString("email");
                int salariu = resultSet.getInt("salariu");
                String nationalitate = resultSet.getString("nationalitate");
                int varsta = resultSet.getInt("varsta");
                int inaltime = resultSet.getInt("inaltime");
                String pozitie = resultSet.getString("pozitie");
                String picior = resultSet.getString("picior");
                jucatori.add(new Jucator(nume, prenume, telefon, email, salariu, nationalitate,varsta,inaltime,pozitie,picior));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        jucatori.sort(Comparator.comparing(Jucator::getNume));
        return  jucatori;
    }

    @Override
    public List<Jucator> findPlayersUnder(int varsta) {
        return null;
    }

    @Override
    public List<Jucator> findPlayersByFoot(String picior) {
        return null;
    }
}

