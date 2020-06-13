package edu.magasinapi;

import java.util.List;

public interface ClientInterface {
	
	public List<Produit> getAchats();
	
	public void addProduit(Produit produit);
	
	public ClientInterface creerNouveauClient(String nom, MagasinInterface magasin);

}
