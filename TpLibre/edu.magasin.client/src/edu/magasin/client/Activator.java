package edu.magasin.client;

import org.osgi.framework.BundleActivator; 
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import edu.magasinapi.ClientInterface;
import edu.magasinapi.MagasinInterface;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	private ServiceRegistration<ClientInterface> myServiceRegistration;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Client bundle a démarré");
		myServiceRegistration = (ServiceRegistration<ClientInterface>)
				bundleContext.registerService(ClientInterface.class.getName(), new
				Client("MonClient", null), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		myServiceRegistration.unregister();
		myServiceRegistration=null;
		System.out.println("Client bundle s'est éteint");
	}

}
