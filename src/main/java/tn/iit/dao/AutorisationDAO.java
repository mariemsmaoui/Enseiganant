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

public class AutorisationDAO {
    private Connection connection;

    public AutorisationDAO() {
        connection = JDBCUtils.getConnection();
    }

    public void addAutorisation(Autorisation autorisation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO autorisations (idEnseignant, dateAutorisation, heuresAutorisees) VALUES (?, ?, ?)"
            );
            preparedStatement.setInt(1, autorisation.getEnseignant().getIdEnseignant());
            preparedStatement.setDate(2, new java.sql.Date(autorisation.getDateAutorisation().getTime()));
            preparedStatement.setInt(3, autorisation.getHeuresAutorisees());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAutorisation(Autorisation autorisation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE autorisations SET idEnseignant = ?, dateAutorisation = ?, heuresAutorisees = ? WHERE idAutorisation = ?"
            );
            preparedStatement.setInt(1, autorisation.getEnseignant().getIdEnseignant());
            preparedStatement.setDate(2, new java.sql.Date(autorisation.getDateAutorisation().getTime()));
            preparedStatement.setInt(3, autorisation.getHeuresAutorisees());
            preparedStatement.setInt(4, autorisation.getIdAutorisation());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAutorisation(int idAutorisation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM autorisations WHERE idAutorisation = ?"
            );
            preparedStatement.setInt(1, idAutorisation);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Autorisation getAutorisationById(int idAutorisation) {
        Autorisation autorisation = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM autorisations WHERE idAutorisation = ?"
            );
            preparedStatement.setInt(1, idAutorisation);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int idEnseignant = rs.getInt("idEnseignant");
                Enseignant enseignant = getEnseignantById(idEnseignant);

                Date dateAutorisation = rs.getDate("dateAutorisation");
                int heuresAutorisees = rs.getInt("heuresAutorisees");

                autorisation = new Autorisation(idAutorisation, enseignant, dateAutorisation, heuresAutorisees);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autorisation;
    }

    public List<Autorisation> getAllAutorisations() {
        List<Autorisation> autorisations = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM autorisations");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idAutorisation = rs.getInt("idAutorisation");
                int idEnseignant = rs.getInt("idEnseignant");
                Enseignant enseignant = getEnseignantById(idEnseignant);
                Date dateAutorisation = rs.getDate("dateAutorisation");
                int heuresAutorisees = rs.getInt("heuresAutorisees");

                Autorisation autorisation = new Autorisation(idAutorisation, enseignant, dateAutorisation, heuresAutorisees);
                autorisations.add(autorisation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autorisations;
    }

    private Enseignant getEnseignantById(int idEnseignant) {
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        Enseignant enseignant = enseignantDAO.getEnseignantById(idEnseignant);
        return enseignant;
    }

}
