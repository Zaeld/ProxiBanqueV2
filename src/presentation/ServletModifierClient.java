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
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String sitprof = request.getParameter("situationProfessionelle");
				String numtel = request.getParameter("numeroTelephone");
				String adresse = request.getParameter("adresse");
				String cp = request.getParameter("codePostal");
				String ville = request.getParameter("ville");

				// TODO creation d'un client avec les infos recuperees
				Client monClient = new Client(nom, prenom, adresse, cp, ville, numtel, sitprof);

				// soumetter les parametre de la requ�te a la couche service et recuperation du user
				ClientService service = new ClientService();
				Client reponse = service.updateClient(monClient);

				// reponse utilisateur
				RequestDispatcher dispatcher;

				if (reponse != null) {
					//TODO Ajouter une alerte de reussite
					ClientService monService = new ClientService();
					List<Client> listeClient = new ArrayList<Client>();
					listeClient = monService.getAllClient();
					request.setAttribute("listeClient", listeClient);
					dispatcher = request.getRequestDispatcher("acceuilV2.jsp");
					dispatcher.forward(request, response);
				} else {
					//TODO Ajouter une alerte de probleme
					dispatcher = request.getRequestDispatcher("modificationClient.jsp");
					dispatcher.forward(request, response);
				}//TODO rajouter cas des 10 clients deja existant ?
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
