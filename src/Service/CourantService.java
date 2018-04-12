package Service;

import java.util.List;



import dAO.CompteCourantDAO;
import domaine.Courant;

public class CourantService {
	CompteCourantDAO dao = new CompteCourantDAO();

	public boolean createCourant(Courant compte) {
		return dao.createCourant(compte);
	
	}

	public Courant getCourant(Courant compte) {
		return dao.getCourant(compte);
	}

	public Courant updateCourant(Courant compte) {
		return dao.updateCourant(compte);
	}

	public boolean deleteCourant(Courant compte) {
		return dao.deleteCourant(compte);
	}

	public List<Courant> getAllCourant(Courant compte) {
		return dao.getAllCourant();
		}
}
