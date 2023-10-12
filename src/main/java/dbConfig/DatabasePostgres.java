package dbConfig;

import props.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePostgres {
    private static final DatabasePostgres INSTANCE = new DatabasePostgres();
    private final Connection connection;

    private DatabasePostgres(){
        String url = PropertyReader.getConnectionUrlForPostgres();
        String user = PropertyReader.getUserForPostgres();
        String password = PropertyReader.getPasswordForPostgres();

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.out.println("Unable create connection: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DatabasePostgres getInstance(){
        return INSTANCE;
    }

}
