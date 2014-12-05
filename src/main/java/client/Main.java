package client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.CarService;

public class Main {
	public static void main(String[] args) {
		System.out.println("Start");
		final CarService carService;
		try {
			carService = lookupRemoteCarService();
		} catch (NamingException e) {
			e.printStackTrace();
			return;
		}
		int markCount = carService.getCarCount();
		System.out.println("Mark count = "+markCount);
		System.out.println("End");
	}

	private static CarService lookupRemoteCarService() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (CarService) context
				.lookup("ejb:EProject/EProjectEJB//CarServiceBean!services.CarService");
	}

}