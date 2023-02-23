import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Retour {
    private Emprunt emprunt;
    private LocalDate dateRetour;

    public Retour(Emprunt emprunt, LocalDate dateRetour) {
        this.emprunt = emprunt;
        this.dateRetour = dateRetour;
    }

    // Méthodes d'accès aux attributs
    public Emprunt getEmprunt() {
        return emprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    // Méthode pour calculer la durée de l'emprunt
    public long getDureeEmprunt() {
        //On a utiliser la methode between() de la classe "ChronoUnit" pour calculer la
        // différence entre la date d'emprunt (stockée dans l'objet "emprunt") et la date de retour
        return ChronoUnit.DAYS.between(emprunt.getDateEmprunt(), dateRetour);
    }

    // Méthode pour calculer le montant de l'amende en cas de retard
    public double calculerAmende() {
        long dureeRetard = ChronoUnit.DAYS.between(emprunt.getDateRetourPrevu(), dateRetour);
        if (dureeRetard <= 0) {
            return 0.0;
        } else {
            // On calcule l'amende en fonction du nombre de jours de retard
            double amendeParJour = 0.5; // Exemple de montant d'amende par jour de retard
            return amendeParJour * dureeRetard;
        }
    }
}
