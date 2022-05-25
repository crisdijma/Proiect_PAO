import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiletDbService implements BiletService{

    private Connection connection;

    public BiletDbService() throws SQLException {
        this.connection = DbConnection.getInstance();
    }

    @Override
    public void save(Bilet bilet) {

        String query = "insert into bilet values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, bilet.getSector());
            preparedStatement.setInt(2, bilet.getPret());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Bilet bilet) {

    }

    @Override
    public void deleteBySector(String sector) {

    }

    @Override
    public List<Bilet> getBySector(String sector) {
        return null;
    }

    @Override
    public List<Bilet> getAllSorted() {
        List<Bilet> bilete = new ArrayList<>();
        String query = "select * from bilet";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                String sector = resultSet.getString("sector");
                int pret = resultSet.getInt("pret");

                bilete.add(new Bilet(sector,pret));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        bilete.sort(Comparator.comparing(Bilet::getPret));
        return  bilete;
    }
}
