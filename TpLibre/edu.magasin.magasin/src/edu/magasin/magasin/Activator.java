package edu.magasin.magasin;

import java.util.ArrayList;

import org.osgi.framework.BundleActivator; 
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import edu.magasinapi.MagasinInterface;
import edu.magasinapi.Produit;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	private ServiceRegistration<MagasinInterface> myServiceRegistration;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Magasin bundle a démarré");
		myServiceRegistration = (ServiceRegistration<MagasinInterface>)
				bundleContext.registerService(MagasinInterface.class.getName(), new
				Magasin("MonMagasin", new ArrayList<Produit>()), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		myServiceRegistration.unregister();
		myServiceRegistration=null;
		System.out.println("Magasin bundle s'est éteint");
	}

}
