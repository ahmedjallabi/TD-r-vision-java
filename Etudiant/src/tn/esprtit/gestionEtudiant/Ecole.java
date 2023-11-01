package tn.esprtit.gestionEtudiant;


public class Ecole {
    public String nom ;
    public Etudiant[] etudiants ;
    public int nbrEtudiants ;
    public final int capaciteMaximale = 500 ;
    float sommeDesMoyennes = 0;
    int nombreEtudiants3A = 0;
    float sommeDesSalaires = 0;
    int nombreAlternants = 0;


    public Ecole (String nom ){
        this.nom = nom;
        this.etudiants = new  Etudiant[500];
        this.nbrEtudiants = 0;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        if (nbrEtudiants < capaciteMaximale) {
            etudiants[nbrEtudiants] = etudiant;
            nbrEtudiants++;
            System.out.println("Étudiant ajouté avec succès !");
        } else {
            System.out.println("Capacité maximale atteinte, impossible d'ajouter plus d'étudiants.");
        }
    }

    public int rechercherEtudiant(Etudiant e) {
        for (int i = 0; i < nbrEtudiants; i++) {
            if (e.getNom().equals(etudiants[i].getNom())) {
                return i;
            }
        }
        return -1;
    }

    public float getMoyenneDes3A() {
        for (int i = 0; i < nbrEtudiants; i++) {
            if (etudiants[i] instanceof Etudiant3eme) {
                sommeDesMoyennes += etudiants[i].getMoyenne();
                nombreEtudiants3A++;
            }
        }

        if (nombreEtudiants3A == 0) {
            return 0;
        }

        return sommeDesMoyennes / nombreEtudiants3A;
    }

    public float moyenneSalaireAlternants() {


        for (int i = 0; i < nbrEtudiants; i++) {
            if (etudiants[i] instanceof EtudiantAlternance) {
                sommeDesSalaires += ((EtudiantAlternance) etudiants[i]).getSalaire();
                nombreAlternants++;
            }
        }

        if (nombreAlternants == 0) {
            return 0;
        }

        return sommeDesSalaires / nombreAlternants;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Nom de l'école:" + nom);
        System.out.println("Liste des étudiants");
        for (int i = 0; i < nbrEtudiants; i++) {
            System.out.println(etudiants[i].toString());
        }

        return sb.toString();
    }

    public void changerEcole(Etudiant etd, Ecole nouvelleEcole) throws EtudiantExisteException {
        int indiceEtudiant = rechercherEtudiant(etd);

        if (indiceEtudiant != -1) {
            for (int i = indiceEtudiant; i < nbrEtudiants - 1; i++) {
                etudiants[i] = etudiants[i + 1];
            }
            nbrEtudiants--;

            nouvelleEcole.ajouterEtudiant(etd);
            System.out.println(etd.getNom() + " a changé d'école avec succès.");
        } else {
            try {
                throw new EtudiantIntrouvableException("Cet étudiant n'est pas inscrit à cette école.");
            } catch (EtudiantIntrouvableException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
