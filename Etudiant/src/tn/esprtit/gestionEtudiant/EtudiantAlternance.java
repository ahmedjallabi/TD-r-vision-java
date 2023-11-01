package tn.esprtit.gestionEtudiant;

public class EtudiantAlternance extends Etudiant{

    private int salaire ;
    public EtudiantAlternance(int identifiant, String nom, String prenom, float moyenne ){
        super(identifiant, nom, prenom, moyenne);
        this.salaire = salaire ;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public void ajouterUneAbsence(){
        salaire -= 50;
        if (salaire <= 0) {
            salaire = 0;
        }

    }
    public String toString() {
        return "EtudiantAlternance{" +
                "identifiant=" + getIdentifiant() +
                ", nom='" + getNom() +
                ", prenom='" + getPrenom() +
                ", salaire='" + getSalaire() +
                ", moyenne='" + getMoyenne() +
                '}';
    }
}
