package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_notes_scolaires", "root", "");
            System.out.println("Connexion réussie !");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Echec de la connexion.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}