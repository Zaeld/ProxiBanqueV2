package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Client;
import service.ClientService;

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
		
		String idClientS =request.getParameter("idClient");
		int idClient = Integer.parseInt(idClientS); 
		Client monClient = new Client();
		monClient.setIdClient(idClient);
		ClientService service = new ClientService();
		monClient = service.getClient(monClient);
		request.setAttribute("client", monClient);
		RequestDispatcher dispatcher;
		String direction = (String) request.getParameter("direction");
		System.out.println(direction);
		if (direction.equals("gerer")) {
			dispatcher = request.getRequestDispatcher("client.jsp");
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
