package service;

import dAO.LoginDAO;
import domaine.Conseiller;
import domaine.Login;

/**
 * @author Stagiaire
 *
 */
public class LoginService {

	// La classe LoginService permet de faire le lien entre la couche présentation
	// et la classe LoginDAO

	// Déclaration
	LoginDAO loginDAO = new LoginDAO();

	public Conseiller VerifLogin(Login login) {
		return loginDAO.VerificationLogin(login);
	}
}
