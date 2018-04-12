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
		ClientService monService = new ClientService();
		List<Client> listeClient = new ArrayList<Client>();
		listeClient = monService.getAllClient();//devra prendre en compte que si c'est le g�rant il n'a pas de clients
		request.setAttribute("listeClient", listeClient);
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
