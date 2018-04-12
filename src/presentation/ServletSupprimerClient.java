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
 * Servlet implementation class ServletSupprimerClient
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
		
		//récupération de la réponse et transformation en boolean
		String texte = request.getParameter("reponse");
		boolean reponse = false;
		if (texte.equals("oui")) {
			reponse = true;
		}
		
		RequestDispatcher dispatcher;
		if (reponse == true) {//si réponse oui on supprime le client
			String a = request.getParameter("idClient");
			int idClient = Integer.parseInt(a);
			Client monClient = new Client();
			monClient.setIdClient(idClient);
			ClientService service = new ClientService();
			boolean retour = service.deleteClient(monClient);
			if (retour == true) {//Si le client est supprimé correctement on renvoie sur lapage de réussite
				dispatcher = request.getRequestDispatcher("operationReussie.jsp");
				dispatcher.forward(request, response);
			} else {//Sinon on renvoie vers une page d'erreur
				dispatcher = request.getRequestDispatcher("suppressionClientErreur.jsp");
				dispatcher.forward(request, response);
			}
		} else {//si la réponse est non on renvoie vers l'acceuil
			dispatcher = request.getRequestDispatcher("acceuilV2.jsp");
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
