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
import service.ClientService;
import service.ConseillerService;

/**
 * Servlet implementation class ServletRetourAcceuil
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//récupération du conseiller de la session
		HttpSession maSession = request.getSession(true);
		Conseiller conseiller = (Conseiller) maSession.getAttribute("conseiller");
		
		//Creation de la liste de client gere a renvoyer
		ClientService monService = new ClientService();
		List<Client> listeClient = new ArrayList<Client>();
		listeClient = monService.getAllClientConseiller(conseiller);
		maSession.setAttribute("listeClient", listeClient);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("acceuilV2.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
