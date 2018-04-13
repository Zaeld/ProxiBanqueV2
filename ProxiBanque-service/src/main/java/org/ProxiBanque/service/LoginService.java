package org.ProxiBanque.service;

import org.ProxiBanque.dao.LoginDAO;

import org.ProxiBanque.domaine.Conseiller;
import org.ProxiBanque.domaine.Login;

/**
 * @author Stagiaire
 *
 */
public class LoginService {

	// La classe LoginService permet de faire le lien entre la couche pr�sentation
	// et la classe LoginDAO

	// D�claration
	LoginDAO loginDAO = new LoginDAO();

	/**
	 * @param login
	 * @return
	 */
	public Conseiller VerifLogin(Login login) {
		return loginDAO.VerificationLogin(login);
	}
}
