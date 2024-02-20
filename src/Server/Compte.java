package Server;

public class Compte {
	
	private static int c=1;
	private int id;
	private String nom;
	private Float solde;
	
	public int getId() {
		return id;
	}public Compte(String nom, Float solde) {
		super();
		this.id = c++;
		this.nom = nom;
		this.solde = solde;
	}

	public Compte() {
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getSolde() {
		return solde;
	}
	public void setSolde(Float solde) {
		this.solde = solde;
	}
	public void crediteSolde(Float solde2) {
		this.solde = solde + solde2;
	}
	public void debitSolde(Float solde2) {
		
		this.solde = solde - solde2;
	}
}
