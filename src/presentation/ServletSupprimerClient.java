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

		String texte = request.getParameter("reponse");
		boolean reponse = false;
		if (texte.equals("oui")) {
			reponse = true;
		}
		System.out.println(texte);
		System.out.println(reponse);
		if (reponse == true) {
			String a = request.getParameter("idClient");
			int idClient = Integer.parseInt(a);
			Client monClient = new Client();
			monClient.setIdClient(idClient);
			ClientService service = new ClientService();
			boolean retour = service.deleteClient(monClient);
			if (retour == true) {
				ClientService monService = new ClientService();
				List<Client> listeClient = new ArrayList<Client>();
				listeClient = monService.getAllClient();
				request.setAttribute("listeClient", listeClient);
				RequestDispatcher dispatcher;
				dispatcher = request.getRequestDispatcher("acceuilV2.jsp");
				dispatcher.forward(request, response);
			} else {
				// TODO devra renvoyer vers page d'erreur
				RequestDispatcher dispatcher;
				dispatcher = request.getRequestDispatcher("suppressionClient.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			ClientService monService = new ClientService();
			List<Client> listeClient = new ArrayList<Client>();
			listeClient = monService.getAllClient();
			request.setAttribute("listeClient", listeClient);
			RequestDispatcher dispatcher;
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
