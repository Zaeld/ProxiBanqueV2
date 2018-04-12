package domaineCompte;

public enum TypeCarte {
	
	// enumération
	ELECTRON ("Visa Electron"),
	PREMIER("Visa Premier");
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name ="";
	
	private TypeCarte(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
