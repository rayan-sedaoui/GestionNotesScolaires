package dao;
import entites.Note;
import entites.Etudiant;
import entites.Module;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDaoImpl implements IDao<Note> {

    @Override
    public boolean create(Note o) {
        try {
            String req = "INSERT INTO note (id_etudiant, id_module, session, valeur) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getEtudiant().getId());
            ps.setInt(2, o.getModule().getId());
            ps.setString(3, o.getSession());
            ps.setDouble(4, o.getValeur());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean update(Note o) {
        try {
            String req = "UPDATE note SET id_etudiant=?, id_module=?, session=?, valeur=? WHERE id=?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getEtudiant().getId());
            ps.setInt(2, o.getModule().getId());
            ps.setString(3, o.getSession());
            ps.setDouble(4, o.getValeur());
            ps.setInt(5, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean delete(int id) {
        try {
            String req = "DELETE FROM note WHERE id=?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public Note findById(int id) { return null; }

    @Override
    public List<Note> findAll() {
        List<Note> liste = new ArrayList<>();
        try {
            // Jointure pour récupérer les noms au lieu des IDs
            String req = "SELECT n.id, n.session, n.valeur, e.id as id_e, e.nom as nom_e, m.id as id_m, m.nom as nom_m " +
                         "FROM note n " +
                         "JOIN etudiant e ON n.id_etudiant = e.id " +
                         "JOIN module m ON n.id_module = m.id";
            Statement st = connexion.Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                Etudiant et = new Etudiant(rs.getInt("id_e"), rs.getString("nom_e"), "", "");
                Module mo = new Module(rs.getInt("id_m"), rs.getString("nom_m"), 0);
                liste.add(new Note(rs.getInt("id"), et, mo, rs.getString("session"), rs.getDouble("valeur")));
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
        return liste;
    }
    public double calculerMoyenneGenerale() {
    double moyenne = 0.0;
    try {
        String req = "SELECT AVG(valeur) FROM note"; 
        java.sql.ResultSet rs = connexion.Connexion.getConnection().createStatement().executeQuery(req);
        if (rs.next()) {
            moyenne = rs.getDouble(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return Math.round(moyenne * 100.0) / 100.0;
}

}