import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection;

    private DbConnection() {

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            //url = protocol:db vendor:db server url/db name
            String url = "jdbc:mysql://localhost:3306/proiectpao";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}