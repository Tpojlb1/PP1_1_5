package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

private static final String connectionURL = "jdbc:mysql://localhost:3306/username";
private static final String passwordUser = "root";
private static final String userName = "root";

private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

public static Connection getConnection() throws SQLException {
    Connection getConnection = null;
    try {
        Class.forName(DRIVER);
        getConnection = DriverManager.getConnection(connectionURL, userName, passwordUser);
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    return getConnection;
}

}
