package entites;

public class Etudiant {
    private int id;
    private String nom;
    private String filiere;
    private String niveau;

    public Etudiant() {
    }

   public Etudiant(String nom, String filiere, String niveau) {
        this.nom = nom;
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public Etudiant(int id, String nom, String filiere, String niveau) {
        this.id = id;
        this.nom = nom;
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getFiliere() { return filiere; }
    public void setFiliere(String filiere) { this.filiere = filiere; }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }

    @Override
    public String toString() {
        return nom;
    }
}