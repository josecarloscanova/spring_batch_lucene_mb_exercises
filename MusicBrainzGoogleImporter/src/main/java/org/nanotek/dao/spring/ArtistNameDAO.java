package org.nanotek.dao.spring;

import java.util.List;

import org.nanotek.beans.ArtistName;

public interface ArtistNameDAO<T extends ArtistName>{

	public T findById (Long id);
	
	public List<?> findByName (String value);
	
}
