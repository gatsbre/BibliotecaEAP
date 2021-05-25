package servicii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLobject {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/proiectjava";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "ciscosecpa55";
    private final Connection connection;

    private SQLobject(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = getConnection();
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException("Something went wrong during connection/driver invocation!!!!");
        }
    }


    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DATABASE_URL,DATABASE_USER_NAME,DATABASE_PASSWORD);
    }

    private static final class SINGLETON_HOLDER{
        private static final SQLobject INSTANCE = new SQLobject();
    }

    public static SQLobject getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    public Connection getDBConnection() {
        return this.connection;
    }
}