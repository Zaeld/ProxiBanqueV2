package domaineCompte;

public class Carte {
	
	// propriétés
	private CCourant compteCourant;
	private TypeCarte type;
	
	// constructor
	public Carte() {
		this.type = TypeCarte.ELECTRON;
	}
	// getters et setters
	public CCourant getCompteCourant() {
		return compteCourant;
	}
	public void setCompteCourant(CCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	public TypeCarte getType() {
		return type;
	}
	public void setType(TypeCarte type) {
		this.type = type;
	}

}
