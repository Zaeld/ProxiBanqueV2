package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Client;
import service.ClientService;

/**
 * Servlet implementation class ServletModifierClient
 */
@WebServlet("/ServletModifierClient")
public class ServletModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifierClient() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperation des donnees
		String idClientS = request.getParameter("idClient");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String sitprof = request.getParameter("situationProfessionelle");
		String numtel = request.getParameter("numeroTelephone");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String cp = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String id = request.getParameter("idConseiller");
		int idConseiller = Integer.parseInt(id);

		int idClient = Integer.parseInt(idClientS);
		
		// creation d'un client avec les infos recuperees
		Client monClient = new Client(idClient, nom, prenom, adresse, cp, ville, email, numtel,  sitprof, idConseiller);

		// les parametre de la requete sont soumis a la couche service et recuperation de la reponse
		ClientService service = new ClientService();
		Client reponse = service.updateClient(monClient);

		// reponse utilisateur
		RequestDispatcher dispatcher;

		if (reponse != null) {
			dispatcher = request.getRequestDispatcher("operationReussie.jsp");
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("modificationClientErreur.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
