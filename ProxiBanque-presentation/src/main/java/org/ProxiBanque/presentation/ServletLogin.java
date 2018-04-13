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
import org.ProxiBanque.domaine.Login;
import org.ProxiBanque.service.ClientService;
import org.ProxiBanque.service.LoginService;

/**
 * Servlet implementation class ServeltLogin : Servlet qui verifie si le login
 * et le mot de passe d'un formulaire sont present dans la base de donnee. Si
 * oui genere une session puis va chercher le conseiller correspondant a la
 * combinaison login+PWD pour le set dans la session ainsi que la liste de ses
 * clients.
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperation des login et mot de passe
		String login = request.getParameter("login");
		String pwd = request.getParameter("mdp");

		// Création de l'utilisateur et vérification de son existance
		Login user = new Login(login, pwd);
		LoginService service = new LoginService();

		// retirer infos en dur
		Conseiller conseiller = service.VerifLogin(user);

		RequestDispatcher dispatcher;

		if (conseiller != null) {// Si e conseiller existe on créé une session et on renvoie sur l'acceuil avec
									// la liste de ses clients
			// Creation d'une session prenant en compte le user
			HttpSession maSession = request.getSession();
			maSession.setAttribute("conseiller", conseiller);
			// Creation de la liste de client gere a renvoyer
			ClientService monService = new ClientService();
			List<Client> listeClient = new ArrayList<Client>();
			listeClient = monService.getAllClientConseiller(conseiller);
			maSession.setAttribute("listeClient", listeClient);

			dispatcher = request.getRequestDispatcher("acceuilV2.jsp");
			dispatcher.forward(request, response);
		} // sinon on renvoie sur une page d'erreur
		dispatcher = request.getRequestDispatcher("mauvaisLogin.jsp");
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
