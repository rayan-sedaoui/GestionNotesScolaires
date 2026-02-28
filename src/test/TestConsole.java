package test;

import dao.EtudiantDaoImpl;
import dao.ModuleDaoImpl;
import dao.NoteDaoImpl;
import entites.Etudiant;
import entites.Module;
import entites.Note;
import java.util.List;

public class TestConsole {

    public static void main(String[] args) {
        
        System.out.println("--- DÉBUT DU TEST ---");

        EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
        ModuleDaoImpl moduleDao = new ModuleDaoImpl();
        NoteDaoImpl noteDao = new NoteDaoImpl();

       System.out.println("\n[1] Création d'un étudiant...");
        Etudiant e1 = new Etudiant("Yassine", "Informatique", "L3");
        if(etudiantDao.create(e1)) {
            System.out.println("succès : Etudiant ajouté !");
        } else {
            System.out.println("erreur : Impossible d'ajouter l'étudiant.");
        }

       System.out.println("\n[2] Création d'un module...");
        Module m1 = new Module("Programmation Orientée Objet", 4);
        if(moduleDao.create(m1)) {
            System.out.println("succès : Module ajouté !");
        } else {
            System.out.println("erreur : Impossible d'ajouter le module.");
        }

       List<Etudiant> tousLesEtudiants = etudiantDao.findAll();
        Etudiant dernierEtudiant = tousLesEtudiants.get(tousLesEtudiants.size() - 1);
        
        List<Module> tousLesModules = moduleDao.findAll();
        Module dernierModule = tousLesModules.get(tousLesModules.size() - 1);

        System.out.println("\n[3] Ajout d'une note pour " + dernierEtudiant.getNom() + " en " + dernierModule.getNom() + "...");
        Note n1 = new Note(dernierEtudiant, dernierModule, "Normale", 18.5);
        
        if(noteDao.create(n1)) {
            System.out.println("succès : Note enregistrée !");
        } else {
            System.out.println("erreur : Impossible d'enregistrer la note.");
        }

       System.out.println("\n[4] Liste de toutes les notes en base :");
        List<Note> notes = noteDao.findAll();
        notes.stream().forEach((n) -> {
            System.out.println("- Etudiant : " + n.getEtudiant().getNom()
                    + " | Module : " + n.getModule().getNom()
                    + " | Note : " + n.getValeur());
        });
        
        System.out.println("\n--- FIN DU TEST ---");
    }
}