package org.nanotek.indexer.util.key;

import java.rmi.server.ObjID;
import java.rmi.server.UID;
import java.util.UUID;

public class KeyServiceFactory{
	
	private UIDService uidService; 
	private GenericUUIDService uuidService; 
	private ObjIDService objIDService; 
	
	public KeyServiceFactory() 
	{}
	
	public KeyServiceFactory(Boolean instantiate) 
	{ 
		if (instantiate == true) { 
			uidService = new UIDService();
			uuidService = new GenericUUIDService();
			objIDService = new ObjIDService();
		}
	}
	
	public synchronized Object getKey (Class <? extends Object> clazz) throws KeyServiceFactoryException
	{ 
		
		if (clazz.equals(UID.class))
			return uidService.getKey();
		if (clazz.equals(UUID.class)) 
			return uuidService.getKey();
		if (clazz.equals(ObjID.class))
			return objIDService.getKey();

		throw new KeyServiceFactoryException("No defined factory service for provided class");
	}

	public static KeyServiceFactory newInstance() {
		return new KeyServiceFactory(true);
	}

	public UIDService getUidService() {
		return uidService;
	}

	public void setUidService(UIDService uidService) {
		this.uidService = uidService;
	}

	public GenericUUIDService getUuidService() {
		return uuidService;
	}

	public void setUuidService(GenericUUIDService uuidService) {
		this.uuidService = uuidService;
	}

	public ObjIDService getObjIDService() {
		return objIDService;
	}

	public void setObjIDService(ObjIDService objIDService) {
		this.objIDService = objIDService;
	}

}
