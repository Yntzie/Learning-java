package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection CON;
    public static final String URL = "jdbc:mysql://";
    public static final String DBNAME = "b_1_bengkel";
    public static final String PATH = "localhost:3306/" + DBNAME;
    
    public Connection makeConnection() {
        System.out.println("Opening database...");
        try {
            CON = DriverManager.getConnection(URL + PATH, "root", "");
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println("error opening database");
            System.out.println(e);
        }
        return CON;
    }
    
    public void closeConnection() {
        System.out.println("closing database...");
        try {
            CON.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println("error closing database");
            System.out.println(e);
        }
    }
    
}
