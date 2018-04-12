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
	// La classe GestionCompteService regroupe la m�thode d'affichage de tout les
	// comptes ainsi que les m�thodes r�gissant les interactions entre comptes comme
	// le syst�me de virement

	// D�claration
	CompteCourantDAO courantDAO = new CompteCourantDAO();
	CompteEpargneDAO epargneDAO = new CompteEpargneDAO();

	// La m�thode d�biter et cr�diter permet de modifier le solde d'un compte en
	// param�tre d'entr�e en fonction de la varible somme aussi en param�tre
	// d'entr�e de m�thode. Les m�thodes sont surcharg�es pour s'adapter au type de
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
	// La m�thode virementCompteACompte permet de faire un virement entre deux
	// comptes en fonction de la variable somme. La m�thode est surcharg�e pour
	// s'adapter au type de compte en param�tre d'entr�e.

	/**
	 * @param compted�biteur
	 * @param comptecr�diteur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Courant compted�biteur, Courant comptecr�diteur, double somme) {

		// On r�cup�re le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = compted�biteur.getSolde();
		double solde2avant = comptecr�diteur.getSolde();

		// On effectue le virement en appelant les m�thodes d�biter() et cr�diter()
		// correspondant et on r�cup�re les soldes finaux des comptes
		double solde1apr�s = this.debiter(compted�biteur, somme).getSolde();
		double solde2apr�s = this.crediter(comptecr�diteur, somme).getSolde();

		// Si les soldes des comptes ont �t� modifi� par le virement, la m�thode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1apr�s && solde2avant != solde2apr�s)
			return true;
		else
			return false;
	}

	/**
	 * @param compted�biteur
	 * @param comptecr�diteur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Courant compted�biteur, Epargne comptecr�diteur, double somme) {

		// On r�cup�re le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = compted�biteur.getSolde();
		double solde2avant = comptecr�diteur.getSolde();

		// On effectue le virement en appelant les m�thodes d�biter() et cr�diter()
		// correspondant et on r�cup�re les soldes finaux des comptes
		double solde1apr�s = this.debiter(compted�biteur, somme).getSolde();
		double solde2apr�s = this.crediter(comptecr�diteur, somme).getSolde();

		// Si les soldes des comptes ont �t� modifi� par le virement, la m�thode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1apr�s && solde2avant != solde2apr�s)
			return true;
		else
			return false;
	}

	/**
	 * @param compted�biteur
	 * @param comptecr�diteur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Epargne compted�biteur, Courant comptecr�diteur, double somme) {

		// On r�cup�re le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = compted�biteur.getSolde();
		double solde2avant = comptecr�diteur.getSolde();

		// On effectue le virement en appelant les m�thodes d�biter() et cr�diter()
		// correspondant et on r�cup�re les soldes finaux des comptes
		double solde1apr�s = this.debiter(compted�biteur, somme).getSolde();
		double solde2apr�s = this.crediter(comptecr�diteur, somme).getSolde();

		// Si les soldes des comptes ont �t� modifi� par le virement, la m�thode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1apr�s && solde2avant != solde2apr�s)
			return true;
		else
			return false;
	}

	/**
	 * @param compted�biteur
	 * @param comptecr�diteur
	 * @param somme
	 * @return
	 */
	public boolean virementCompteACompte(Epargne compted�biteur, Epargne comptecr�diteur, double somme) {

		// On r�cup�re le solde de chaque compte avant le virement pour les tester plus
		// tard.
		double solde1avant = compted�biteur.getSolde();
		double solde2avant = comptecr�diteur.getSolde();

		// On effectue le virement en appelant les m�thodes d�biter() et cr�diter()
		// correspondant et on r�cup�re les soldes finaux des comptes
		double solde1apr�s = this.debiter(compted�biteur, somme).getSolde();
		double solde2apr�s = this.crediter(comptecr�diteur, somme).getSolde();

		// Si les soldes des comptes ont �t� modifi� par le virement, la m�thode
		// retourne true, sinon elle retourne false
		if (solde1avant != solde1apr�s && solde2avant != solde2apr�s)
			return true;
		else
			return false;
	}

	// M�thode retournant toutes les entr�es de la table 'compte' de la
	// base de donn�e.
	/**
	 * @param CCourantDAO
	 * @param CEpargneDAO
	 * @return
	 */
	public List<CompteBancaire> getAllCompte() {

		// D�claration
		List<CompteBancaire> listCompte = new ArrayList<CompteBancaire>();

		// On ajoute la liste des comptes �pargnes et courant � la liste de compte
		// bancaire
		listCompte.addAll(courantDAO.getAllCourant());
		listCompte.addAll(epargneDAO.getAllEpargne());
		return listCompte;
	}

}
