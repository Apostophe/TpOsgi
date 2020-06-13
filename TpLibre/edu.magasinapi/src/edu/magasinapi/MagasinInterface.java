package edu.magasinapi;

import java.util.List;

public interface MagasinInterface {
	
	public List<Produit> getProduits();
	
	public void acheterProduit(Produit produit) throws MagasinException;
	
	public void ajouterProduitAuCatalogue(Produit produit);
	
	public MagasinInterface creerMagasin(String nom, List<Produit> articles);

}
