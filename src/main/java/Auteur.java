import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Auteur {
    private String nom;
    private LocalDate dateNaissance;
    private String nationalite;
    private List<Livre> bibliographie;

    public Auteur(String nom, LocalDate dateNaissance, String nationalite, List<Livre> bibliographie) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
        this.bibliographie = bibliographie;
    }
    // Méthodes d'accès aux attributs
    public String getNom() {
        return nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public List<Livre> getBibliographie() {
        return bibliographie;
    }
    public void ajouterLivre(Livre unLivre){
        bibliographie.add(unLivre);
    }

    public void supprimerLivre(Livre unLivre){
        bibliographie.remove(unLivre);
    }

}
