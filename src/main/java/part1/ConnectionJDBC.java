package part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) {

        // 1 - Set parameters to connect to the MySQL database.

        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "digital_innovation_one";
        String user = "root";
        String password = "password";

        // 2 - Construction of the connection string.
        String connectionUrl = "jdbc:" +
                driver + "://" +
                dataBaseAddress + "/" +
                dataBaseName; // "jdbc:mysql://localhost/digital_innovation_one"


        // 3 - Create connection using DriverManager, passing as parameters the connection string, user and user password.
        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            System.out.println("SUCCESS when connecting to the MySQL database!");
        } catch (SQLException e) {
            System.out.println("FAILED to connect to the MySQL database!");
            e.printStackTrace();
        }

      /*  String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";

        try(Connection conn = DriverManager.getConnection(urlConnection, "root", "password")) {
            System.out.println("Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Fail");
        }*/
    }
}
