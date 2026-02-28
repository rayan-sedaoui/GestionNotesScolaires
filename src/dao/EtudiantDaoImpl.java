package dao;
import entites.Etudiant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDaoImpl implements IDao<Etudiant> {

   public int compterEtudiants() {
        int total = 0;
        try {
            String req = "SELECT COUNT(*) FROM etudiant";
           ResultSet rs = connexion.Connexion.getConnection().createStatement().executeQuery(req);
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public boolean create(Etudiant o) {
        try {
            String req = "INSERT INTO etudiant (nom, filiere, niveau) VALUES (?, ?, ?)";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getFiliere());
            ps.setString(3, o.getNiveau());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean update(Etudiant o) {
        try {
            String req = "UPDATE etudiant SET nom=?, filiere=?, niveau=? WHERE id=?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getFiliere());
            ps.setString(3, o.getNiveau());
            ps.setInt(4, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean delete(int id) {
        try {
            String req = "DELETE FROM etudiant WHERE id=?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public Etudiant findById(int id) { return null; }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> liste = new ArrayList<>();
        try {
            String req = "SELECT * FROM etudiant";
            ResultSet rs = connexion.Connexion.getConnection().createStatement().executeQuery(req);
            while(rs.next()) {
                liste.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("filiere"), rs.getString("niveau")));
            }
        } catch (SQLException e) { }
        return liste;
    }

    public int compterModules() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}