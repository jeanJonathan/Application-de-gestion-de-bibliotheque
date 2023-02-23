import java.time.LocalDate;
import java.util.Date;

public class Emprunt {
    private Livre livreEmprunte;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevu;
    private Utilisateur utilisateur;

    public Emprunt(Livre livreEmprunte, LocalDate dateEmprunt, LocalDate dateRetourPrevu, Utilisateur utilisateur) {
        this.livreEmprunte = livreEmprunte;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevu = dateRetourPrevu;
        this.utilisateur = utilisateur;
    }
    // Méthodes d'accès aux attributs
    public Livre getLivreEmprunte() {
        return livreEmprunte;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }
    public LocalDate getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    // Methode pour modifier la date de retour preuve
    public void setDateRetourPrevu(LocalDate dateRetour){
        this.dateRetourPrevu = dateRetour;
    }
    //Methode pour verifier si l'emprunt est en retard
    public boolean estEnRetard(){
        LocalDate dateAujourdhui= LocalDate.now();
        //Si la date de aujourd'hui se trouve apres la date prevue retoure true
        return dateAujourdhui.isAfter(dateRetourPrevu);
    }
    /*Rmq: On utilise LocalDate au lieu de date car date est obsolete depuis java 8*/


}
