package service;

import dAO.ConseillerDAO;

import dAO.LoginDAO;
import domaine.Conseiller;
import domaine.Login;

public class LoginService {
	LoginDAO loginDAO = new LoginDAO();
	ConseillerDAO employeDAO = new ConseillerDAO();

	public Conseiller VerifLogin(Login login) {
		return loginDAO.VerificationLogin(login);

	}
}
