package service;

import dAO.LoginDAO;
import domaine.Conseiller;
import domaine.Login;

/**
 * @author Stagiaire
 *
 */
public class LoginService {

	// La classe LoginService permet de faire le lien entre la couche pr�sentation
	// et la classe LoginDAO

	// D�claration
	LoginDAO loginDAO = new LoginDAO();

	public Conseiller VerifLogin(Login login) {
		return loginDAO.VerificationLogin(login);
	}
}
