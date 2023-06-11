package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tn.iit.model.Autorisation;
import tn.iit.model.Enseignant;
import tn.iit.utils.JDBCUtils;

public class EnseignantDAO {
    // Establish a connection to your SQL database (e.g., MySQL)
    private Connection connection;

    public EnseignantDAO() {
        // Initialize  database connection
        connection = JDBCUtils.getConnection();
    }
    // Méthode pour obtenir la liste de tous les enseignants
    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> enseignants = new ArrayList<>();
       

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM enseignants");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idEnseignant = rs.getInt("idEnseignant");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                int cin = rs.getInt("cin");
                int telephone = rs.getInt("telephone");
                Enseignant enseignant = new Enseignant(idEnseignant, nom, email, cin, telephone);
             // Set the authorizations for the enseignant
                enseignant.setAuthorisations(getAuthorisationsForEnseignant(idEnseignant));
                enseignants.add(enseignant);     
            }
          
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;
    }
    
    
    public List<Autorisation> getAuthorisationsForEnseignant(int idEnseignant) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Autorisation> authorisations = new ArrayList<>();

        try {
            // Establish database connectioneditEnseignantCIN
            connection = JDBCUtils.getConnection();

            // Prepare the SQL statement
            String sql = "SELECT * FROM authorisations WHERE idEnseignant = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idEnseignant);

            // Execute the query
            resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                int idAutorisation = resultSet.getInt("idAutorisation");
                Date dateAutorisation = resultSet.getDate("dateAutorisation");
                int heuresAutorisees = resultSet.getInt("heuresAutorisees");

                // Create an Autorisation object
           //     Autorisation autorisation = new Autorisation(idAutorisation, idEnseignant, dateAutorisation, heuresAutorisees);

                // Add the autorisation to the list
              //  authorisations.add(autorisation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
          //  JDBCUtils.closeResultSet(resultSet);
           // JDBCUtils.closeStatement(statement);
            JDBCUtils.closeConnection(connection);
        }

        return authorisations;
    }


    
    public Enseignant getEnseignantById(int idEnseignant) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Enseignant enseignant = null;

        try {
            // Establish database connection
            connection = JDBCUtils.getConnection();

            // Prepare the SQL statement
            String sql = "SELECT * FROM enseignants WHERE idEnseignant = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idEnseignant);

            // Execute the query
            resultSet = statement.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                int id = resultSet.getInt("idEnseignant");
                String nom = resultSet.getString("nom");
                String email = resultSet.getString("email");
                int cin = resultSet.getInt("cin");
                int telephone = resultSet.getInt("telephone");

                // Create an Enseignant object
                enseignant = new Enseignant(id, nom, email, cin, telephone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
           // JDBCUtils.closeResultSet(resultSet);
            //JDBCUtils.closeStatement(statement);
            JDBCUtils.closeConnection(connection);
        }

        return enseignant;
    }

    
    
    //Méthode pour ajouter un enseignant
    public void ajouterEnseignant(Enseignant enseignant) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO enseignants(idEnseignant, nom, email, cin, telephone) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, enseignant.getNom());
            preparedStatement.setString(3, enseignant.getEmail());
            preparedStatement.setInt(4, enseignant.getCin());
            preparedStatement.setInt(5, enseignant.getTelephone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un enseignant
    public void supprimerEnseignant(int idEnseignant) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM enseignant WHERE idEnseignant=?");
            preparedStatement.setInt(1, idEnseignant);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour modifier un enseignant
    public void modifierEnseignant(Enseignant enseignant) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE enseignants SET nom=?, email=?, cin=?, telephone=? WHERE idEnseignant=?");
            preparedStatement.setString(1, enseignant.getNom());
            preparedStatement.setString(2, enseignant.getEmail());
            preparedStatement.setInt(3, enseignant.getCin());
            preparedStatement.setInt(4, enseignant.getTelephone());
            preparedStatement.setInt(5, enseignant.getIdEnseignant());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 // Méthode pour supprimer un enseignant
    public void deleteEnseignant(int idEnseignant) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM enseignants WHERE idEnseignant = ?");
            preparedStatement.setInt(1, idEnseignant);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



   
}

