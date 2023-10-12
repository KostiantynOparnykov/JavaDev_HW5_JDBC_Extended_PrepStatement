import dbConfig.DatabasePostgres;
import sqlReader.SqlReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static final String SQL_FILE = "src/main/resources/sql/init_db.sql";

    public static void main(String[] args) {
        String sqlUpdate = new SqlReader().read(SQL_FILE);
        Connection connection = DatabasePostgres.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlUpdate);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
