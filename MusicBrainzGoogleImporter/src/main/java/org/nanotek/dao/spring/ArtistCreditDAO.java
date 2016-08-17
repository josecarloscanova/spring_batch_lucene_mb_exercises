package org.nanotek.dao.spring;

import java.util.List;

import org.nanotek.beans.ArtistCredit;

public interface ArtistCreditDAO<T extends ArtistCredit>{

	public T findById (Long id);
	public List<ArtistCredit> findByKeyId (Long keyId);
	
}
