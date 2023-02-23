import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private List<Emprunt> emprunts;

    public Utilisateur(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.emprunts = new ArrayList<>();
    }

    // Méthodes d'accès aux attributs
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String unPrenom){
        this.prenom=unPrenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String uneAdresse) {
        this.adresse=uneAdresse;
    }

    public String getTelephone() {
        return telephone;
    }
    public  void setTelephone(String unTelephone){
        this.telephone=unTelephone;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    //Methode pour ajouter un emprunt
    public void ajouterEmprunt(Emprunt unEmprunt){
        emprunts.add(unEmprunt);
    }
    public void retirerEmprunt(Emprunt unEmprunt){
        emprunts.remove(unEmprunt);
    }
    //On implemente une limite d'emprunt que l'utilisateur doit pas depassee

    public boolean aAtteintLimiteEmprunt(){
        int limiteEmprunt=3;
        return getEmprunts().size()>=limiteEmprunt;
    }
    // Méthode pour afficher les informations sur l'utilisateur
    public void afficherInfo() {
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Adresse : " + adresse);
        System.out.println("Téléphone : " + telephone);
        System.out.println("Emprunts en cours : ");

        for (Emprunt emprunt : emprunts) {
            System.out.println("- " + emprunt.getLivreEmprunte().getTitre() + " (" + emprunt.getLivreEmprunte().getAuteur().getNom() + ")");
        }
    }


}
