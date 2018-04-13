package org.ProxiBanque.service;

import java.util.List;

import org.ProxiBanque.dao.CompteCourantDAO;
import org.ProxiBanque.domaine.Courant;

/**
 * @author Stagiaire
 *
 */
public class CourantService {

	// La classe CourantService permet de faire le lien entre la couche présentation
	// et la classe CompteCourantDAO

	// Déclaration
	CompteCourantDAO dao = new CompteCourantDAO();

	/**
	 * @param compte
	 * @return
	 */
	public boolean createCourant(Courant compte) {
		return dao.createCourant(compte);
	}

	/**
	 * @param compte
	 * @return
	 */
	public Courant getCourant(Courant compte) {
		return dao.getCourant(compte);
	}

	/**
	 * @param compte
	 * @return
	 */
	public Courant updateCourant(Courant compte) {
		return dao.updateCourant(compte);
	}

	/**
	 * @param compte
	 * @return
	 */
	public boolean deleteCourant(Courant compte) {
		return dao.deleteCourant(compte);
	}

	/**
	 * @param compte
	 * @return
	 */
	public List<Courant> getAllCourant(Courant compte) {
		return dao.getAllCourant();
	}
}
