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
import domaine.CompteBancaire;
import domaine.Courant;
import domaine.Epargne;
import service.ClientService;
import service.GestionCompteService;

/**
 * Servlet implementation class ServletAcceuilRedirection
 */
@WebServlet("/ServletAcceuilRedirection")
public class ServletAcceuilRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAcceuilRedirection() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupère le client à partir de l'ID
		String idClientS =request.getParameter("idClient");
		int idClient = Integer.parseInt(idClientS); 
		Client monClient = new Client();
		monClient.setIdClient(idClient);
		ClientService service = new ClientService();
		monClient = service.getClient(monClient);
		request.setAttribute("client", monClient);
		
		//redirection selon le boutton cliqué
		RequestDispatcher dispatcher;
		String direction = (String) request.getParameter("direction");
		if (direction.equals("listeCompte")) {
			//Récupération des comptes courant et epargne du client
			Courant courant = service.getCompteCourant(monClient);
			Epargne epargne = service.getCompteEpargne(monClient);
			request.setAttribute("courant", courant);
			request.setAttribute("epargne", epargne);
			dispatcher = request.getRequestDispatcher("client.jsp");
		}else if (direction.equals("virement")) {
			//Récupération des comptes courant et epargne du client
			Courant courant = service.getCompteCourant(monClient);
			Epargne epargne = service.getCompteEpargne(monClient);
			
			//Récupération de tous les comptes et des clients associés
			GestionCompteService serviceCompte = new GestionCompteService();
			List<CompteBancaire> listeCompte = serviceCompte.getAllCompte();
			
			request.setAttribute("courant", courant);
			request.setAttribute("epargne", epargne);
			request.setAttribute("listeCompte", listeCompte);
			dispatcher = request.getRequestDispatcher("virement.jsp");
		}else if (direction.equals("modifier")) {
			dispatcher = request.getRequestDispatcher("modificationClient.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("suppressionClient.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
