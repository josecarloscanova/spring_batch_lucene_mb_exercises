package org.nanotek.dao.spring;

import java.util.List;

import org.nanotek.beans.ArtistAlias;

public interface ArtistAliasDAO<T extends ArtistAlias> {

	public T findById (Long id);
	public List<ArtistAlias> findByKeyId (Long keyId);
	
}
