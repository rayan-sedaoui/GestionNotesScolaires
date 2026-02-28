
# 🎓 Application de Gestion des Notes Scolaires

![Version](https://img.shields.io/badge/version-1.0-blue.svg)
![Java](https://img.shields.io/badge/Java-Swing-orange.svg)
![MySQL](https://img.shields.io/badge/Base_de_données-MySQL-lightgrey.svg)

## 📝 Description du projet
Ce projet est une application de bureau (Desktop) développée en Java avec l'interface graphique Swing. Elle permet à l'administration d'un établissement scolaire de gérer facilement les étudiants, les modules d'enseignement et de saisir les notes. L'application intègre également un tableau de bord statistique avec des graphiques dynamiques pour le suivi global.

---

## 🎥 Démonstration Vidéo

Découvrez l'application en action (connexion sécurisée, gestion des étudiants, saisie des notes et affichage des statistiques) dans cette courte vidéo de présentation :

🎬 

https://github.com/user-attachments/assets/422ae1f1-ce2b-4351-88e1-574a211e8622



---

## ✨ Fonctionnalités Principales
* **Sécurité :** Authentification sécurisée de l'administrateur avec hachage des mots de passe.
* **Gestion des Étudiants :** Ajout, modification, suppression et affichage complet de la liste des étudiants.
* **Recherche Avancée :** Filtrage dynamique des étudiants par nom ou par filière.
* **Gestion des Notes :** Saisie, modification et association des notes aux étudiants par module.
* **Tableau de Bord (Statistiques) :** Visualisation des données globales avec des graphiques générés via JFreeChart (répartition par filière, moyennes, etc.).
* **Déploiement :** Application livrée avec un installeur exécutable (`mysetup.exe`) pour une installation native sous Windows.

## 🛠️ Technologies Utilisées
* **Langage :** Java (JDK 8+)
* **Interface Graphique :** Java Swing
* **Base de données :** MySQL (via JDBC)
* **Bibliothèques externes :** JFreeChart (pour les statistiques graphiques)
* **Outils de développement :** NetBeans IDE, phpMyAdmin
* **Packaging :** Inno Setup (pour la création de l'installeur `.exe`)

---

## 📐 Architecture et Modélisation UML

Cette section présente l'architecture logicielle de l'application.

### 1. Diagramme des Cas d'Utilisation (Use Case)
Ce diagramme illustre les interactions possibles entre l'Administrateur (l'acteur principal) et le système.

![WhatsApp Image 2026-02-28 at 14 12 44](https://github.com/user-attachments/assets/b726a571-1f37-47e5-a036-e8e3885e3d21)


### 2. Diagramme de Classes
Ce diagramme détaille la structure orientée objet de l'application, les entités de la base de données (Étudiant, Module, Note, Utilisateur) et les classes de l'interface graphique.

<img width="919" height="583" alt="Screenshot 2026-02-28 143508" src="https://github.com/user-attachments/assets/32f05002-b6fd-4a50-bb0c-6bbf9310c6e5" />



---

## 🚀 Installation et Exécution

### Prérequis
* Avoir installé Java (JRE) sur la machine.
* Avoir un serveur local avec MySQL actif (ex: XAMPP, WAMP, ou Laragon).

### Étape 1 : Configuration de la Base de Données
1. Lancer les services Apache et MySQL via XAMPP/WAMP.
2. Ouvrir phpMyAdmin (`http://localhost/phpmyadmin`).
3. Créer une nouvelle base de données nommée `gestion_notes_scolaires`.
4. Importer le fichier SQL fourni avec ce projet (ex: `base_de_donnees.sql`) pour créer les tables et insérer l'administrateur par défaut.

### Étape 2 : Lancer l'application

**Option A : Via l'installeur (Recommandé - Déploiement natif)**
1. Double-cliquer sur le fichier `GestionNotesScolaires.exe` fourni dans le dossier de rendu.
2. Suivre les instructions d'installation classiques de Windows.
3. Lancer l'application depuis le raccourci créé sur le bureau.

**Option B : Via le fichier exécutable Java (JAR)**
1. Naviguer dans le dossier `dist`.
2. Double-cliquer sur le fichier `GestionNotesScolaires.jar`. *(Note : assurez-vous que le sous-dossier `lib` contenant les bibliothèques JFreeChart et le connecteur MySQL est bien présent à côté du fichier .jar)*.
