package connexion;
import java.sql.Connection; 
import java.sql.DriverManager;

public class Connexion {
    private static Connection cn;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_notes_scolaires", "root", "");
        } catch (Exception e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return cn;
    }
}