import java.rmi.server.ObjID;
import java.rmi.server.UID;
import java.util.UUID;

import org.nanotek.indexer.util.key.KeyServiceFactory;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;



public class TestKeyService {

	/**
	 * @param args
	 * @throws KeyServiceFactoryException 
	 */
	public static void main(String[] args) throws KeyServiceFactoryException {
		KeyServiceFactory kf = new KeyServiceFactory(true);
		System.out.println(kf.getKey(UID.class).toString());
		System.out.println(kf.getKey(UUID.class).toString());
		System.out.println(kf.getKey(ObjID.class).toString());
		
	}

}
