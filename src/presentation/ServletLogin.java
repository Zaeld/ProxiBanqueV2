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
import javax.servlet.http.HttpSession;

import domaine.Client;
import domaine.Conseiller;
import domaine.Login;
import service.ClientService;
import service.LoginService;

/**
 * Servlet implementation class ServeltLogin
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
		
		//recuperation des login et mot de passe
		String login = request.getParameter("login");
		String pwd = request.getParameter("mdp");

		/* TODO verification du login et mot de passe
		 * LoginService service = new LoginService();
		 * int resultat = service.verifLogin(login, pwd); Conseiller
		 * 
		 * 0=mauvais --> renvoie sur index.jsp
		 * 1=conseiller --> renvoie sur acceuilV2.jsp
		 * 2=gerant --> renvoie sur page propre au gerant
		 */

		//creation de la reponse et du user en attendant que le service soit gere
		boolean reponse = true;
		Conseiller user = new Conseiller("Blabla", "Bliblou", 1);
		
		if (reponse == true) {
			//Creation d'une session prenant en compte le user
			HttpSession maSession = request.getSession();
			maSession.setAttribute("user", user);
			//Creation de la liste de client gere a renvoyer
			ClientService monService = new ClientService();
			List<Client> listeClient = new ArrayList<Client>();
			listeClient = monService.getAllClient();//devra prendre en compte que si c'est le gerant il n'a pas de clients
			maSession.setAttribute("listeClient", listeClient);
			//renvoie a l'acceuil
			RequestDispatcher dispatcher = request.getRequestDispatcher("acceuilV2.jsp");
			dispatcher.forward(request, response);
		} else {
			//renvoie sur l'index.jsp avec message error
			RequestDispatcher dispatcher = request.getRequestDispatcher("mauvaisLogin.jsp");
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
