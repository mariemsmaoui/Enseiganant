package tn.iit.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.dao.EnseignantDAO;
import tn.iit.model.Enseignant;
import tn.iit.pdf.AutorisationPDFGenerator;

/**
 * Servlet implementation class AutorisationController
 */
@WebServlet("/AutorisationController")
public class AutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EnseignantDAO enseignantDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutorisationController() {
        super();
        enseignantDAO = new EnseignantDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Enseignant> enseignants = enseignantDAO.getAllEnseignants();
        //System.out.println(enseignants.toString());

        request.setAttribute("enseignants", enseignants);

        RequestDispatcher dispatcher = request.getRequestDispatcher("autorisation.jsp");
        dispatcher.forward(request, response);	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEnseignant = Integer.parseInt(request.getParameter("id"));
        Enseignant e = enseignantDAO.getEnseignantById(idEnseignant);
        ByteArrayOutputStream outputStream = AutorisationPDFGenerator.generatePDF(e);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + e.getNom() + "_autorization.pdf");

        OutputStream out = response.getOutputStream();
        outputStream.writeTo(out);
        out.flush();
        out.close();
	}

}
