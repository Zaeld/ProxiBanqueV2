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
		ClientService serviceClient = new ClientService();
		monClient = serviceClient.getClient(monClient);
		
		//récupération du conseiller de la session
		HttpSession maSession = request.getSession(true);
		
		//Récupération des comptes courant et epargne du client
		Courant courant = serviceClient.getCompteCourant(monClient);
		Epargne epargne = serviceClient.getCompteEpargne(monClient);
		
		//Récupération de tous les comptes et des clients associés
		GestionCompteService serviceCompte = new GestionCompteService();
		List<CompteBancaire> listeCompte = serviceCompte.getAllCompte();
		
		//set des attributs dans la session
		maSession.setAttribute("courant", courant);
		maSession.setAttribute("epargne", epargne);
		maSession.setAttribute("listeCompte", listeCompte);
		maSession.setAttribute("client", monClient);
		
		//redirection selon le boutton cliqué
		RequestDispatcher dispatcher;
		String direction = (String) request.getParameter("direction");
		if (direction.equals("listeCompte")) {
			dispatcher = request.getRequestDispatcher("client.jsp");
		}else if (direction.equals("virement")) {			
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
