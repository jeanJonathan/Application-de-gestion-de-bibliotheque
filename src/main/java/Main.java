import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Connection con = null;

        try {
            // Chargement le pilote JDBC MySQL placer dans le repectoire lib
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établissement de la connexion avec la base de données bibliotheque_bd
            con = DriverManager.getConnection("jdbc:mysql://localhost/bibliotheque_bd", "root", "");

            // Vérification de la connexion a réussi
            //Si elle reussie
            if (con != null) {
                System.out.println("Connexion établie avec succès !");
            } else {//Sinon
                System.out.println("Erreur de connexion !");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
