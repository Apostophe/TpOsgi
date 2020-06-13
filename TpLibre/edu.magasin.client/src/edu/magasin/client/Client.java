package edu.magasin.client;

import java.util.ArrayList;
import java.util.List;

import edu.magasinapi.ClientInterface;
import edu.magasinapi.MagasinInterface;
import edu.magasinapi.Produit;

public class Client implements ClientInterface {

	public String nom;
	public List<Produit> achats;
	public MagasinInterface magasin;
	
	@Override
	public List<Produit> getAchats() {
		return this.achats;
	}

	@Override
	public void addProduit(Produit produit) {
		this.achats.add(produit);
		System.out.println(produit.getNom() + " a bien été ajouté à l'inventaire de " + this.nom);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAchats(List<Produit> achats) {
		this.achats = achats;
	}

	public Client(String nom, MagasinInterface magasin) {
		super();
		this.nom = nom;
		this.achats = new ArrayList<>();
		this.magasin = magasin;
		System.out.println("Client " + nom + " a bien été créé");
	}

	@Override
	public ClientInterface creerNouveauClient(String nom, MagasinInterface magasin) {
		Client newClient = new Client(nom, magasin);
		return newClient;
	}

	public MagasinInterface getMagasin() {
		return magasin;
	}

	public void setMagasin(MagasinInterface magasin) {
		this.magasin = magasin;
	}

}
