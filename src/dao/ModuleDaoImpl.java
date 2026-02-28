package dao;
import entites.Module;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleDaoImpl implements IDao<Module> {

    public int compterModules() {
        int total = 0;
        try {
            String req = "SELECT COUNT(*) FROM module";
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
    public boolean create(Module o) {
        try {
            String req = "INSERT INTO module (nom, coefficient) VALUES (?, ?)";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setDouble(2, o.getCoefficient());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean update(Module o) {
        try {
            String req = "UPDATE module SET nom=?, coefficient=? WHERE id=?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setDouble(2, o.getCoefficient());
            ps.setInt(3, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean delete(int id) {
        try {
            String req = "DELETE FROM module WHERE id=?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public Module findById(int id) { return null; }

 @Override
public List<Module> findAll() {
    List<Module> liste = new ArrayList<>();
    try {
        String req = "SELECT * FROM module";
        ResultSet rs = connexion.Connexion.getConnection().createStatement().executeQuery(req);
        while(rs.next()) {
          Module m = new Module();
            m.setId(rs.getInt("id"));
            m.setNom(rs.getString("nom"));
            m.setCoefficient((int) rs.getDouble("coefficient")); 
            liste.add(m);
        }
    } catch (SQLException e) { 
        System.out.println("Erreur findAll Module: " + e.getMessage());
    }
    return liste;
}
}