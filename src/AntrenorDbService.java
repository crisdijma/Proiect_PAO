import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AntrenorDbService implements AntrenorService{


    private Connection connection;

    public AntrenorDbService() throws SQLException {
        this.connection = DbConnection.getInstance();
    }


    @Override
    public void save(Antrenor antrenor) {

        String query = "insert into antrenor values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, antrenor.getNume());
            preparedStatement.setString(2, antrenor.getPrenume());
            preparedStatement.setString(3, antrenor.getTelefon());
            preparedStatement.setString(4, antrenor.getEmail());
            preparedStatement.setInt(5, antrenor.getSalariu());
            preparedStatement.setString(6, antrenor.getNationalitate());
            preparedStatement.setString(7, antrenor.getAgent());
            preparedStatement.setString(8, antrenor.getLicenta());
            preparedStatement.setString(9, antrenor.getPozitie());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Antrenor antrenor) {

    }

    @Override
    public List<Antrenor> getByNume(String nume) {
        return null;
    }

    @Override
    public List<Antrenor> getAllSorted() {
        List<Antrenor> antrenori = new ArrayList<>();
        String query = "select * from antrenor";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                String nume = resultSet.getString(2);
                String prenume = resultSet.getString("prenume");
                String telefon = resultSet.getString("telefon");
                String email = resultSet.getString("email");
                int salariu = resultSet.getInt("salariu");
                String nationalitate = resultSet.getString("nationalitate");
                String agent = resultSet.getString("agent");
                String licenta = resultSet.getString("licenta");
                String pozitie = resultSet.getString("pozitie");
                antrenori.add(new Antrenor(nume, prenume, telefon, email, salariu, nationalitate,agent,licenta,pozitie));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        antrenori.sort(Comparator.comparing(Antrenor::getNume));
        return  antrenori;
    }
}
