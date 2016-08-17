package org.nanotek.indexer.util.key;

import java.util.UUID;

public class GenericUUIDService extends BaseKeyService<UUID> {

	@Override
	public UUID getKey() {
		return UUID.randomUUID();
	}

	public UUID getKey(String val) 
	{ 
		return UUID.fromString(val);
	}
	
	public UUID getKey (byte[] bytes) 
	{ 
		return UUID.nameUUIDFromBytes(bytes);
	}
}
