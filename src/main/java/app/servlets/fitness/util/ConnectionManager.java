package app.servlets.fitness.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static app.servlets.fitness.util.Constants.*;

public class ConnectionManager {

    static {
        loadConnection();
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadConnection() {
        try {
            Class.forName(CLASS_NAME_MYSQL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(ERROR_LOADING_THE_JDBC_DRIVER);
        }
    }

    private ConnectionManager() {

    }
}
