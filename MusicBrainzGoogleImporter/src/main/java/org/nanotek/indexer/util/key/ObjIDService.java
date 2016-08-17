package org.nanotek.indexer.util.key;

import java.rmi.server.ObjID;

public class ObjIDService extends BaseKeyService<ObjID> {

	@Override
	public ObjID getKey() {
		return new ObjID();
	}

}
