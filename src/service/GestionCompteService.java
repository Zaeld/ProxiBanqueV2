package service;

import java.util.ArrayList;

import java.util.List;

import dAO.CompteCourantDAO;
import dAO.CompteEpargneDAO;
import domaine.CompteBancaire;
import domaine.Courant;
import domaine.Epargne;

/**
 * @author Stagiaire
 *
 */
public class GestionCompteService {
	// La classe GestionCompteService regroupe la méthode d'affichage de tout les
	// comptes ainsi que les méthodes régissant les interactions entre comptes comme
	// le système de virement

	// Déclaration
	CompteCourantDAO courantDAO = new CompteCourantDAO();
	CompteEpargneDAO epargneDAO = new CompteEpargneDAO();

	// La méthode débiter et créditer permet de modifier le solde d'un compte en
	// paramètre d'entrée en fonction de la varible somme aussi en paramètre
	// d'entrée de méthode. Les méthodes sont surchargées pour s'adapter au type de
	// compte.

	/**
	 * @param compte
	 * @param somme
	 * @return
	 */
	public Courant debiter(Courant compte, double somme) {
		compte.setSolde(compte.getSolde() - somme);
		courantDAO.updateCourant(compte);
		return compte;
	}

	/**
	 * @param compte
	 * @param somme
	 * @return
	 */
	public Courant crediter(Courant compte, double somme) {
		compte.setSolde(compte.getSolde() + somme);
		courantDAO.updateCourant(compte);
		return compte;
	}

	/**
	 * @param compte
	 * @param somme
	 * @return
	 */
	public Epargne debiter(Epargne compte, double somme) {
		compte.setSolde(compte.getSolde() - somme);
		epargneDAO.updateEpargne(compte);
		return compte;

	}

	/**
	 * @param compte
	 * @param somme
	 * @return
	 */
	public Epargne crediter(Epargne compte, double somme) {
		compte.setSolde(compte.getSolde() + somme);
		epargneDAO.updateEpargne(compte);
		return compte;
	}
	// La méthode virementCompteACompte permet de faire un virement entre deux
	// comptes en fonction de la variable somme. La méthode est surchargée pour
	// s'adapter au type de compte en paramètre d'entrée.

	/**
	 * @param comptedébiteur
	 * @param comptecréditeur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Courant comptedébiteur, Courant comptecréditeur, double somme) {

		// On récupère le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = comptedébiteur.getSolde();
		double solde2avant = comptecréditeur.getSolde();

		// On effectue le virement en appelant les méthodes débiter() et créditer()
		// correspondant et on récupère les soldes finaux des comptes
		double solde1après = this.debiter(comptedébiteur, somme).getSolde();
		double solde2après = this.crediter(comptecréditeur, somme).getSolde();

		// Si les soldes des comptes ont été modifié par le virement, la méthode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1après && solde2avant != solde2après)
			return true;
		else
			return false;
	}

	/**
	 * @param comptedébiteur
	 * @param comptecréditeur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Courant comptedébiteur, Epargne comptecréditeur, double somme) {

		// On récupère le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = comptedébiteur.getSolde();
		double solde2avant = comptecréditeur.getSolde();

		// On effectue le virement en appelant les méthodes débiter() et créditer()
		// correspondant et on récupère les soldes finaux des comptes
		double solde1après = this.debiter(comptedébiteur, somme).getSolde();
		double solde2après = this.crediter(comptecréditeur, somme).getSolde();

		// Si les soldes des comptes ont été modifié par le virement, la méthode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1après && solde2avant != solde2après)
			return true;
		else
			return false;
	}

	/**
	 * @param comptedébiteur
	 * @param comptecréditeur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Epargne comptedébiteur, Courant comptecréditeur, double somme) {

		// On récupère le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = comptedébiteur.getSolde();
		double solde2avant = comptecréditeur.getSolde();

		// On effectue le virement en appelant les méthodes débiter() et créditer()
		// correspondant et on récupère les soldes finaux des comptes
		double solde1après = this.debiter(comptedébiteur, somme).getSolde();
		double solde2après = this.crediter(comptecréditeur, somme).getSolde();

		// Si les soldes des comptes ont été modifié par le virement, la méthode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1après && solde2avant != solde2après)
			return true;
		else
			return false;
	}

	/**
	 * @param comptedébiteur
	 * @param comptecréditeur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Epargne comptedébiteur, Epargne comptecréditeur, double somme) {

		// On récupère le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = comptedébiteur.getSolde();
		double solde2avant = comptecréditeur.getSolde();

		// On effectue le virement en appelant les méthodes débiter() et créditer()
		// correspondant et on récupère les soldes finaux des comptes
		double solde1après = this.debiter(comptedébiteur, somme).getSolde();
		double solde2après = this.crediter(comptecréditeur, somme).getSolde();

		// Si les soldes des comptes ont été modifié par le virement, la méthode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1après && solde2avant != solde2après)
			return true;
		else
			return false;
	}

	// Méthode retournant toutes les entrées de la table 'compte' de la
	// base de donnée.
	/**
	 * @param CCourantDAO
	 * @param CEpargneDAO
	 * @return
	 */
	public List<CompteBancaire> getAllCompte() {

		// Déclaration
		List<CompteBancaire> listCompte = new ArrayList<CompteBancaire>();

		// On ajoute la liste des comptes épargnes et courant à la liste de compte
		// bancaire
		listCompte.addAll(courantDAO.getAllCourant());
		listCompte.addAll(epargneDAO.getAllEpargne());
		return listCompte;
	}

}
