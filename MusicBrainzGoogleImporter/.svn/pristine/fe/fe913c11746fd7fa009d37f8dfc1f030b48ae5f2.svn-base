package org.nanotek.indexer.util.key;

import java.rmi.server.UID;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;

/**
 * 
 * @author JoseCanova
 * Generates a unique indentifier based on host id and current time in millis.
 *
 */
public class UIDService extends BaseKeyService<UID>{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Service service;
		KeyService<UID>keyService =  new UIDService();
		System.out.println(keyService.getKey());
		System.out.println(keyService.getKeyClass());
		Provider [] provider = Security.getProviders();
		for (int i = 0; i < provider.length; i++)
		{ 
			service = provider[i].getService("MessageDigest" , "SHA-1");
			if (service !=null)
				System.out.println(service.getAlgorithm());
			for (Service services :provider[i].getServices()) 
				System.err.println(services.getAlgorithm());
		}
	}

	@Override
	public UID getKey() {
		return new UID();
	}

}
