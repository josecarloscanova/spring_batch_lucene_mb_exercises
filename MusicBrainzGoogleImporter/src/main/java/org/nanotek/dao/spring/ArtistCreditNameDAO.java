package org.nanotek.dao.spring;


import org.nanotek.beans.ArtistCreditName;

public interface ArtistCreditNameDAO<T extends ArtistCreditName>  {

	public T findById (String id);
	
}
