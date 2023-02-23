import java.time.LocalDate;

public class Livre {
    private String titre;
    private Auteur auteur;
    private int nbPages;
    private LocalDate datePublication;
    private int nbCopiesDisponibles;
    public Livre(String titre, Auteur auteur, int nbPages, LocalDate datePublication, int nbCopiesDisponibles) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.datePublication = datePublication;
        this.nbCopiesDisponibles = nbCopiesDisponibles;
    }

    // Méthodes d'accès aux attributs
    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public int getNbCopiesDisponibles() {
        return nbCopiesDisponibles;
    }
    // Méthode pour vérifier si une copie est disponible
    public boolean estDisponible() {
        return nbCopiesDisponibles > 0;
    }
    // Méthodes pour ajouter ou retirer des copies
    public void ajouterCopies(int nbCopies) {
        nbCopiesDisponibles += nbCopies;
    }

    public void retirerCopies(int nbCopies) {
        nbCopiesDisponibles -= nbCopies;
    }

}
