package org.ProxiBanque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ProxiBanque.domaine.Client;
import org.ProxiBanque.domaine.Conseiller;
import org.ProxiBanque.service.ClientService;

/**
 * Servlet implementation class ServletModifierClient : Servlet qui recupere les
 * informations d'un formulaire puis cree le client correspondant. Elle appel
 * ensuite la couche service pour update les informations du client
 * correspondant dans la base de donnee. Si la reponse n'est pas null, la
 * servlet renvoie vers une page de reussite. Sinon, elle renvoie vers une page
 * d'erreur.
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

		// récupération du conseiller de la session
		HttpSession maSession = request.getSession(true);
		// redirection vers la page de connection si la session est en time out
		if (maSession == null || maSession.getAttribute("conseiller") == null) {
			request.getRequestDispatcher("index.html").forward(request, response);
		}

		// récupération de l'Id du conseiller de la session
		Conseiller conseiller = (Conseiller) maSession.getAttribute("conseiller");
		int idConseiller = conseiller.getIdConseiller();
		// récupération de l'idClient de la session et de son solde total
		Client client = (Client) maSession.getAttribute("client");
		int idClient = client.getIdClient();

		// recuperation des donnees
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String sitprof = request.getParameter("situationProfessionnel");
		String numtel = request.getParameter("numeroTelephone");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String cp = request.getParameter("codePostal");
		String ville = request.getParameter("ville");

		// creation d'un client avec les infos recuperees
		Client monClient = new Client(idClient, nom, prenom, adresse, cp, ville, email, numtel, sitprof, idConseiller);

		// les parametre de la requete sont soumis a la couche service et recuperation
		// de la reponse
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
