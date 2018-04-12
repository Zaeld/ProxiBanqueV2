package presentation;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ServletFormulaire
 */
@WebServlet("/ServletCreerClient")
public class ServletCreerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreerClient() {
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
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String cp = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String id = request.getParameter("idConseiller");
		
		int idConseiller;
		if (id.equals(null)) {
			idConseiller = 0;
		}else {
			idConseiller = Integer.parseInt(id);
		}
		
		//creation d'un client avec les infos recuperees
		Client monClient = new Client(nom, prenom, adresse, cp, ville, numtel, email, sitprof, idConseiller);

		// les parametres de la requete sont soumis a la couche service et recuperation de la réponse
		ClientService service = new ClientService();
		boolean reponse = service.createClient(monClient);

		// reponse utilisateur
		RequestDispatcher dispatcher;

		if (reponse == true) {
			dispatcher = request.getRequestDispatcher("operationReussie.jsp");
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("creationClientErreur.jsp");
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
