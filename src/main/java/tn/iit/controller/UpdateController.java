package tn.iit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.dao.EnseignantDAO;
import tn.iit.model.Enseignant;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnseignantDAO enseignantDAO;

    public UpdateController() {
        super();
        enseignantDAO = new EnseignantDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int enseignantId = Integer.parseInt(request.getParameter("idEnseignant"));

        // Retrieve the existing enseignant from the database using the enseignantDAO
        Enseignant enseignant = enseignantDAO.getEnseignantById(enseignantId);

        // Set the enseignant object as an attribute in the request
        request.setAttribute("enseignant", enseignant);

        // Forward the request to the editEnseignant.jsp page for rendering the edit form
        RequestDispatcher dispatcher = request.getRequestDispatcher("editEnseignant.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEnseignant = Integer.parseInt(request.getParameter("idEnseignant"));
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String cin = request.getParameter("cin");
        String telephone = request.getParameter("telephone");

        // Retrieve the existing enseignant from the database using the enseignantDAO
        Enseignant enseignant = enseignantDAO.getEnseignantById(idEnseignant);

        // Update the enseignant object with the new values obtained from the form
        enseignant.setNom(nom);
        enseignant.setEmail(email);
        enseignant.setCin(Integer.parseInt(cin));
        enseignant.setTelephone(Integer.parseInt(telephone));

        // Call the modifierEnseignant method in the enseignantDAO to persist the changes in the database
        enseignantDAO.modifierEnseignant(enseignant);

        // Redirect to a success page or perform other actions
        response.sendRedirect("EnseignantController");
    }



	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
