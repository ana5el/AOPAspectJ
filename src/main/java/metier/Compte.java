package metier;

public class Compte {

	private Long code;
	private double solde;
	
	public Compte() {
	}
	
	public Compte(Long code, double solde) {
		this.code = code;
		this.solde = solde;
	}
	
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Compte ["+code+" , "+solde+"]";
	}
	
	
}
