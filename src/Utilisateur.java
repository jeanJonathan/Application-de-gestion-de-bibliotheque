import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    private String motDePasse;
    private LocalDate dateInscription;
    private List<Emprunt> emprunts;

    public Utilisateur(String nom, String adresse, String telephone, String email, String motDePasse, LocalDate dateInscription) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = dateInscription;
        this.emprunts = new ArrayList<>();
    }

    // Méthodes d'accès aux attributs
    public String getNom() {
        return nom;
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

    public void setTelephone(String unTelephone){
        this.telephone=unTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String unEmail){
        this.email=unEmail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String unMotDePasse){
        this.motDePasse=unMotDePasse;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
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
        System.out.println("Adresse : " + adresse);
        System.out.println("Téléphone : " + telephone);
        System.out.println("Email : " + email);
        System.out.println("Date d'inscription : " + dateInscription);
        System.out.println("Emprunts en cours : ");

        for (Emprunt emprunt : emprunts) {
            System.out.println("- " + emprunt.getLivreEmprunte().getTitre() + " (" + emprunt.getLivreEmprunte().getAuteur().getNom() + ")");
        }
    }
}
