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
import org.ProxiBanque.service.ClientService;

/**
 * Servlet implementation class ServletSupprimerClient : Servlet qui permet de
 * supprimer un client de la base de donnee. Pour cela elle recupere le client a
 * supprimer via son ID puis appel la couche service. Selon la reponse, elle
 * renvoie vers une page de reussite ou d'echec.
 */
@WebServlet("/ServletSupprimerClient")
public class ServletSupprimerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSupprimerClient() {
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

		// récupération de l'idClient de la session
		Client client = (Client) maSession.getAttribute("client");
		ClientService service = new ClientService();
		boolean retour = service.deleteClient(client);
		RequestDispatcher dispatcher;
		if (retour == true) {// Si le client est supprimé correctement on renvoie sur lapage de réussite
			dispatcher = request.getRequestDispatcher("operationReussie.jsp");
			dispatcher.forward(request, response);
		} else {// Sinon on renvoie vers une page d'erreur
			dispatcher = request.getRequestDispatcher("suppressionClientErreur.jsp");
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
