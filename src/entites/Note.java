package entites;

public class Note {
    private int id;
    private Etudiant etudiant;
    private Module module;
    private String session;
    private double valeur;

   public Note() {
    }

    public Note(Etudiant etudiant, Module module, String session, double valeur) {
        this.etudiant = etudiant;
        this.module = module;
        this.session = session;
        this.valeur = valeur;
    }

    public Note(int id, Etudiant etudiant, Module module, String session, double valeur) {
        this.id = id;
        this.etudiant = etudiant;
        this.module = module;
        this.session = session;
        this.valeur = valeur;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public Module getModule() { return module; }
    public void setModule(Module module) { this.module = module; }

    public String getSession() { return session; }
    public void setSession(String session) { this.session = session; }

    public double getValeur() { return valeur; }
    public void setValeur(double valeur) { this.valeur = valeur; }
}