package entites;

public class Module {
    private int id;
    private String nom;
    private int coefficient;

    public Module() {
    }

    public Module(String nom, int coefficient) {
        this.nom = nom;
        this.coefficient = coefficient;
    }

    public Module(int id, String nom, int coefficient) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getCoefficient() { return coefficient; }
    public void setCoefficient(int coefficient) { this.coefficient = coefficient; }

    @Override
    public String toString() {
        return nom; 
    }
}