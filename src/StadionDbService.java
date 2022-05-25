import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StadionDbService implements StadionService{

    private Connection connection;

    public StadionDbService() throws SQLException {
        this.connection = DbConnection.getInstance();
    }

    public void save(Stadion stadion) {

        String query = "insert into stadion values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, stadion.getDenumire());
            preparedStatement.setInt(2, stadion.getCapacitate());
            preparedStatement.setString(3, stadion.getTip_Gazon());
            preparedStatement.setString(4, stadion.getAdresa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Stadion stadion) {

    }

    @Override
    public Set<Stadion> getAll() {

        Set<Stadion> stadioane = new HashSet<>();
        String query = "select * from stadion";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                // citesc atributele pt fiecare record intors de select
                String denumire = resultSet.getString("denumire");
                int capacitate = resultSet.getInt("capacitate");
                String tip_gazon = resultSet.getString("tip_gazon");
                String adresa = resultSet.getString("adresa");
                stadioane.add(new Stadion(denumire,capacitate,tip_gazon,adresa));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  stadioane;
    }

    @Override
    public Set<Stadion> findStadiumAboveCapacity(int capacitate) {
        return null;
    }

    @Override
    public Set<Stadion> getByDenumire(String denumire) {
        return null;
    }
}
