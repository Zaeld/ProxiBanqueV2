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

	public boolean VirementCompteACompte(Courant comptedébiteur, Courant comptecréditeur, double somme) {
		double solde1avant = comptedébiteur.getSolde();
		double solde2avant = comptecréditeur.getSolde();
		double solde1après = this.debiter(comptedébiteur, somme).getSolde();
		double solde2après = this.crediter(comptecréditeur, somme).getSolde();
		if (solde1avant != solde1après && solde2avant != solde2après)
			return true;
		else
			return false;
	}
	public boolean VirementCourantAEpargne(Courant comptedébiteur, Epargne comptecréditeur, double somme) {
		double solde1avant = comptedébiteur.getSolde();
		double solde2avant = comptecréditeur.getSolde();
		double solde1après = this.debiter(comptedébiteur, somme).getSolde();
		double solde2après = this.crediter(comptecréditeur, somme).getSolde();
		if (solde1avant != solde1après && solde2avant != solde2après)
			return true;
		else
			return false;
		}
	public boolean VirementEpargneACourant(Epargne comptedébiteur, Courant comptecréditeur, double somme) {
		double solde1avant = comptedébiteur.getSolde();
		double solde2avant = comptecréditeur.getSolde();
		double solde1après = this.debiter(comptedébiteur, somme).getSolde();
		double solde2après = this.crediter(comptecréditeur, somme).getSolde();
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
	public List<Courant> getAllCompte(CompteCourantDAO CCourantDAO, CompteEpargneDAO CEpargneDAO) {

		List<Epargne> listCEpargne = new ArrayList<Epargne>();
		List listCompte = new ArrayList<CompteBancaire>();
		listCompte.addAll(CCourantDAO.getAllCourant());
		listCompte.addAll(CEpargneDAO.getAllEpargne());
		return listCompte;
	}

}
