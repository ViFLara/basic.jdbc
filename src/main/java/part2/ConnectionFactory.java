package part2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private ConnectionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {
        // 1 - Declare connection object (you will receive a connection after performing the steps below).
        Connection connection = null;

        // 2 - Load properties file to get parameters needed to communicate with the database.
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")) {

            // 3 - Set parameters to connect to the MySQL database.
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // 4 - Construction of the connection string.
            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString(); //sb.toString() == "jdbc:mysql://localhost/digital_innovation_one".

            // 5 - Create connection using DriverManager, passing as parameters the connection string, user and user password.
            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
                System.out.println("SUCCESS when connecting to the MySQL database!");
            } catch (SQLException e) {
                System.out.println("FAILED to connect");
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("FAILED to attempt to load property files");
            e.printStackTrace();
        }

        return connection;
    }
}

