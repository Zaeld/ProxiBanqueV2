package Service;

import java.util.ArrayList;

import java.util.List;

import dAO.CompteCourantDAO;
import dAO.CompteEpargneDAO;
import domaine.CompteBancaire;
import domaine.Courant;
import domaine.Epargne;

public class GestionCompteService {
	CompteCourantDAO courantDAO = new CompteCourantDAO();
	CompteEpargneDAO epargneDAO = new CompteEpargneDAO();

	public Courant debiter(Courant compte, double somme) {
		compte.setSolde(compte.getSolde() - somme);
		courantDAO.updateCourant(compte);
		return compte;

	}

	public Courant crediter(Courant compte, double somme) {
		compte.setSolde(compte.getSolde() + somme);
		courantDAO.updateCourant(compte);
		return compte;
	}

	public Epargne debiter(Epargne compte, double somme) {
		compte.setSolde(compte.getSolde() - somme);
		epargneDAO.updateEpargne(compte);
		return compte;

	}

	public Epargne crediter(Epargne compte, double somme) {
		compte.setSolde(compte.getSolde() + somme);
		epargneDAO.updateEpargne(compte);
		return compte;
	}

	public boolean VirementCompteACompte(Courant compted�biteur, Courant comptecr�diteur, double somme) {
		double solde1avant = compted�biteur.getSolde();
		double solde2avant = comptecr�diteur.getSolde();
		double solde1apr�s = this.debiter(compted�biteur, somme).getSolde();
		double solde2apr�s = this.crediter(comptecr�diteur, somme).getSolde();
		if (solde1avant != solde1apr�s && solde2avant != solde2apr�s)
			return true;
		else
			return false;
	}
	public boolean VirementCourantAEpargne(Courant compted�biteur, Epargne comptecr�diteur, double somme) {
		double solde1avant = compted�biteur.getSolde();
		double solde2avant = comptecr�diteur.getSolde();
		double solde1apr�s = this.debiter(compted�biteur, somme).getSolde();
		double solde2apr�s = this.crediter(comptecr�diteur, somme).getSolde();
		if (solde1avant != solde1apr�s && solde2avant != solde2apr�s)
			return true;
		else
			return false;
		}
	public boolean VirementEpargneACourant(Epargne compted�biteur, Courant comptecr�diteur, double somme) {
		double solde1avant = compted�biteur.getSolde();
		double solde2avant = comptecr�diteur.getSolde();
		double solde1apr�s = this.debiter(compted�biteur, somme).getSolde();
		double solde2apr�s = this.crediter(comptecr�diteur, somme).getSolde();
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
	public List<Courant> getAllCompte(CompteCourantDAO CCourantDAO, CompteEpargneDAO CEpargneDAO) {

		List<Epargne> listCEpargne = new ArrayList<Epargne>();
		List listCompte = new ArrayList<CompteBancaire>();
		listCompte.addAll(CCourantDAO.getAllCourant());
		listCompte.addAll(CEpargneDAO.getAllEpargne());
		return listCompte;
	}

}
