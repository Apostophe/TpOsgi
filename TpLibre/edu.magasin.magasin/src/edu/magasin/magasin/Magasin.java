package edu.magasin.magasin;

import java.util.List;

import edu.magasinapi.MagasinException;
import edu.magasinapi.MagasinInterface;
import edu.magasinapi.Produit;

public class Magasin implements MagasinInterface {

	public String nom;
	public List<Produit> produitsAVendre;
	
	@Override
	public List<Produit> getProduits() {
		return this.produitsAVendre;
	}

	@Override
	public void acheterProduit(Produit produit) throws MagasinException {
		boolean trouveEtAchete = false;
		for (int i = 0 ; i < this.produitsAVendre.size() ; i++) {
			if (this.produitsAVendre.get(i).equals(produit)) {
				if (this.produitsAVendre.get(i).getQuantite() > 0) {
					this.produitsAVendre.get(i).setQuantite(this.produitsAVendre.get(i).getQuantite()-1);
					trouveEtAchete = true;
					
					if (this.produitsAVendre.get(i).getQuantite() == 0) {
						this.produitsAVendre.remove(i);
					}
				}
			}
		}
		
		if (!trouveEtAchete) {
			throw new MagasinException("Produit non trouve ou quantité insuffisante");
		} else {
			System.out.println(produit.getNom() + " a bien été acheté. Il en reste " + produit.getQuantite());
		}
	}
	
	@Override
	public MagasinInterface creerMagasin(String nom, List<Produit> articles) {
		MagasinInterface newMagasin = new Magasin(nom, articles);
		return newMagasin;
	}

	@Override
	public void ajouterProduitAuCatalogue(Produit produit) {
		this.produitsAVendre.add(produit);
		System.out.println(produit.getNom() + " a été ajouté au catalogue. Le catalogue actuel est " + this.produitsAVendre.toString() );
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getProduitsAVendre() {
		return produitsAVendre;
	}

	public void setProduitsAVendre(List<Produit> produitsAVendre) {
		this.produitsAVendre = produitsAVendre;
	}

	public Magasin(String nom, List<Produit> produitsAVendre) {
		super();
		this.nom = nom;
		this.produitsAVendre = produitsAVendre;
		System.out.println("Magasin " + nom + " a bien été créé");
	}

}
