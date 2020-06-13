package edu.magasinapi;

public class Produit {
	
	private int id;
	private String nom;
	private float prix;
	private int quantite;
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit(int id, String nom, float prix, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public float getPrix() {
		return prix;
	}
	
	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		
		if (!(obj instanceof Produit)) return false;
		
		Produit produitAComparer = (Produit)obj;
		
		if (this.id == produitAComparer.getId()) return true;
		else return false;
	}

	@Override
	public String toString() {
		return "[" + nom + ", prix=" + prix
				+ ", quantite=" + quantite + "]";
	}
	
	
	
}
