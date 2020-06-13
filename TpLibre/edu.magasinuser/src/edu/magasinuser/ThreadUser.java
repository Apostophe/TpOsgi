package edu.magasinuser;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import edu.magasinapi.ClientInterface;
import edu.magasinapi.MagasinException;
import edu.magasinapi.MagasinInterface;
import edu.magasinapi.Produit;

public class ThreadUser extends Thread {

	private BundleContext context = null;
	
	public ThreadUser(BundleContext context) {
		this.context = context;
	}
	
	public void run() {
		System.out.println("Thread user a démarré");
		
		ServiceReference<MagasinInterface> magasinSR = context.getServiceReference(MagasinInterface.class);
		ServiceReference<ClientInterface> clientSR = context.getServiceReference(ClientInterface.class);
		
		MagasinInterface magasinService = context.getService(magasinSR);
		ClientInterface clientService = context.getService(clientSR);
		
		List<Produit> articles = new ArrayList<Produit>();
		Produit p1 = new Produit(1, "pomme", 10, 5);
		Produit p2 = new Produit(2, "poire", 3, 2);
		Produit p3 = new Produit(3, "peche", 20, 15);
		articles.add(p1);
		articles.add(p2);
		articles.add(p3);
		MagasinInterface fruitMax = magasinService.creerMagasin("FruitMax", articles);
		
		ClientInterface robert = clientService.creerNouveauClient("Robert", fruitMax);
		ClientInterface je = clientService.creerNouveauClient("Jean Eudes", fruitMax);
		
		try {
			acheterProduit(robert, fruitMax, p2);
		} catch (MagasinException e) {
			System.out.println("Le produit " + p2.getNom() + " n'existe pas ou n'est plus disponible");
		}
		
		try {
			acheterProduit(je, fruitMax, p3);
		} catch (MagasinException e) {
			System.out.println("Le produit " + p2.getNom() + " n'existe pas ou n'est plus disponible");
		}
		
		Produit p4 = new Produit(4, "banane", 5, 1);
		fruitMax.ajouterProduitAuCatalogue(p4);
	}
	
	public void acheterProduit(ClientInterface client, MagasinInterface magasin, Produit produit) throws MagasinException {
		magasin.acheterProduit(produit);
		client.addProduit(produit);
	}
	
}
