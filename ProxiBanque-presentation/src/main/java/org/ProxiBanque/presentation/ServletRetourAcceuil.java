package org.ProxiBanque.presentation;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ServletRetourAcceuil : Servlet qui permet de
 * revenir a l'acceuil en mettant a jour la liste de client du conseiller de la
 * session a afficher dans la page d'acceuil.
 */
@WebServlet("/ServletRetourAcceuil")
public class ServletRetourAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRetourAcceuil() {
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

		// récupération du conseiller de la session
		Conseiller conseiller = (Conseiller) maSession.getAttribute("conseiller");

		// Creation de la liste de client gere a renvoyer
		ClientService monService = new ClientService();
		List<Client> listeClient = new ArrayList<Client>();
		listeClient = monService.getAllClientConseiller(conseiller);
		maSession.setAttribute("listeClient", listeClient);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("acceuilV2.jsp");
		dispatcher.forward(request, response);
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
