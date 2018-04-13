package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVirement
 */
@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVirement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String compteDebit = request.getParameter("compteDebit");
		String compteCredit = request.getParameter("compteCredit");
		String sommeVirement = request.getParameter("sommeVirement");
		System.out.println(compteDebit);
		System.out.println(compteCredit);
		System.out.println(sommeVirement);
		
		
		RequestDispatcher dispatcher;
		
		boolean retour = true;
		if (retour == true) {//Si le client est supprimé correctement on renvoie sur lapage de réussite
			dispatcher = request.getRequestDispatcher("operationReussie.jsp");
			dispatcher.forward(request, response);
		} else {//Sinon on renvoie vers une page d'erreur
			dispatcher = request.getRequestDispatcher("suppressionClientErreur.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
