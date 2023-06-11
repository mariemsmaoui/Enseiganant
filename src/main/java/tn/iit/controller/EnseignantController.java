package tn.iit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.dao.EnseignantDAO;
import tn.iit.model.Enseignant;

/**
 * Servlet implementation class Enseignant
 */
@WebServlet("/EnseignantController")
public class EnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EnseignantDAO enseignantDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnseignantController() {
        enseignantDAO = new EnseignantDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Enseignant> enseignants = enseignantDAO.getAllEnseignants();
        //System.out.println(enseignants.toString());

        request.setAttribute("enseignants", enseignants);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
	    String email = request.getParameter("email");
	    String cinString = request.getParameter("cin");
	    String telephoneString = request.getParameter("telephone");

	    // Check if the required parameters are empty
	    if (nom.isEmpty() || email.isEmpty() || cinString.isEmpty() || telephoneString.isEmpty()) {
	        // Handle the case when any of the required parameters is empty
	        // Display an error message or redirect the user to an error page
	        // You can use request.getRequestDispatcher().forward() to forward the request to an error page
	        // or you can set an attribute on the request and redirect using response.sendRedirect()
	    } else {
	        try {
	            // Generate the ID automatically
	            int cin = Integer.parseInt(cinString);
	            int telephone = Integer.parseInt(telephoneString);

	            Enseignant enseignant = new Enseignant(0, nom, email, cin, telephone);
	            enseignantDAO.ajouterEnseignant(enseignant);

	            // Redirect to the index page after adding the enseignant
	            response.sendRedirect("EnseignantController");
	        } catch (NumberFormatException e) {
	            // Handle the case when any of the parameters is not a valid integer
	            // Display an error message or redirect the user to an error page
	        }
	    }
	}



}
