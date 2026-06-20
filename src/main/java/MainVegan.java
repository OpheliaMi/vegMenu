import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;


public class MainVegan {
    private static final String URL = "jdbc:sqlite:vegan.db";
    private static final String DRIVER = "org.sqlite.JDBC";

    static Logger log;

    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS menu (" +
                "name text NOT NULL," +
                "receipt text" +
                ");";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.execute("INSERT INTO menu (name, receipt) VALUES('Tofy', 'Pure tofy')");
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL);
    }
}
