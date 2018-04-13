package org.ProxiBanque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ProxiBanque.domaine.Courant;
import org.ProxiBanque.domaine.Epargne;
import org.ProxiBanque.service.CourantService;
import org.ProxiBanque.service.EpargneService;
import org.ProxiBanque.service.GestionCompteService;

/**
 * Servlet implementation class ServletVirement : Servlet qui permet de realiser
 * un virement entre deux comptes. Pour cela elle recupere les comptes a debiter
 * et a crediter ainsi que le montant du virement, puis elle appel la couche
 * service pour effectuer le virement selon si les comptes a debiter et a
 * crediter sont de type courant ou epargne. Elle renvoie ensuite sur une page
 * de reussite ou d'echec selon la reponse de la couche service.
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

		// Récupération des comptes débit et crédit et de la somme du viremment
		String idcompteDebitS = request.getParameter("compteDebit");
		int idcompteDebit = Integer.parseInt(idcompteDebitS);
		String idcompteCreditS = request.getParameter("compteCredit");
		int idcompteCredit = Integer.parseInt(idcompteCreditS);
		String sommeVirementS = request.getParameter("sommeVirement");
		double sommeVirement = Double.parseDouble(sommeVirementS);

		CourantService serviceCourant = new CourantService();
		EpargneService serviceEpargne = new EpargneService();
		GestionCompteService serviceCompte = new GestionCompteService();
		boolean retour = false;

		// on par du principe que le compte débiteur est un compte Courant
		Courant compteDebitC = new Courant();
		compteDebitC.setIdCompte(idcompteDebit);
		compteDebitC = serviceCourant.getCourant(compteDebitC);
		if (compteDebitC == null) {// Si ce n'est pas le cas il est Epargne et on continue
			Epargne compteDebitE = new Epargne();
			compteDebitE.setIdCompte(idcompteDebit);
			compteDebitE = serviceEpargne.getEpargne(compteDebitE);
			// on par du principe que le compte créditeur est un compte Courant
			Courant compteCreditC = new Courant();
			compteCreditC.setIdCompte(idcompteCredit);
			compteCreditC = serviceCourant.getCourant(compteCreditC);
			if (compteCreditC == null) {// Si ce n'est pas le cas il est Epargne et on continue
				Epargne compteCreditE = new Epargne();
				compteCreditE.setIdCompte(idcompteCredit);
				compteCreditE = serviceEpargne.getEpargne(compteCreditE);
				// On effectue un virement epargne epargne
				retour = serviceCompte.virementCompteACompte(compteDebitE, compteCreditE, sommeVirement);
			} else {// Sinon on effectue un virement epargne courant
				retour = serviceCompte.virementCompteACompte(compteDebitE, compteCreditC, sommeVirement);
			}
		} else {// Sinon le compte débiteur est bien un compte courant
				// on par du principe que le compte créditeur est un compte Courant
			Courant compteCreditC = new Courant();
			compteCreditC.setIdCompte(idcompteCredit);
			compteCreditC = serviceCourant.getCourant(compteCreditC);
			if (compteCreditC == null) {// Si ce n'est pas le cas il est Epargne et on continue
				Epargne compteCreditE = new Epargne();
				compteCreditE.setIdCompte(idcompteCredit);
				compteCreditE = serviceEpargne.getEpargne(compteCreditE);
				// On effectue un virement courant epargne
				retour = serviceCompte.virementCompteACompte(compteDebitC, compteCreditE, sommeVirement);
			} else {// Sinon on effectue un virement courant courant
				retour = serviceCompte.virementCompteACompte(compteDebitC, compteCreditC, sommeVirement);
			}
		}

		RequestDispatcher dispatcher;

		if (retour == true) {// Si le client est supprimé correctement on renvoie sur lapage de réussite
			dispatcher = request.getRequestDispatcher("operationReussie.jsp");
			dispatcher.forward(request, response);
		} else {// Sinon on renvoie vers une page d'erreur
			dispatcher = request.getRequestDispatcher("suppressionClientErreur.jsp");
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
