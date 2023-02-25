import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuteurController {

    @PostMapping("/ajouter-auteur")
    public ModelAndView ajouterAuteur(@RequestParam String nom, @RequestParam String nationalite, @RequestParam String dateNaissance) {
        // Conversion de la date de naissance de String vers LocalDate
        LocalDate date = LocalDate.parse(dateNaissance);

        // Création d'un nouvel objet Auteur
        Auteur auteur = new Auteur(nom, date, nationalite, new ArrayList<Livre>());

        // Connexion à la base de données MySQL
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque_bd?useSSL=false", "root", "")) {

            // Préparation de la requête SQL pour insérer l'auteur dans la table auteurs
            String sql = "INSERT INTO auteur(nom, dateNaissance, nationalite, bibliographie) VALUES (?, ?, ?, NULL)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, auteur.getNom());
            statement.setDate(2, java.sql.Date.valueOf(auteur.getDateNaissance()));
            statement.setString(3, auteur.getNationalite());

            // Execution de la requête SQL
            statement.executeUpdate();

            // Fermeture des ressources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Retour de la vue avec un message de succès
        ModelAndView modelAndView = new ModelAndView("ajouter-auteur");
        modelAndView.addObject("message", "L'auteur a été ajouté avec succès !");
        return modelAndView;
    }
}
