package org.nanotek.dao.spring;

import org.nanotek.beans.ArtistKey;

public interface ArtistDAO<T extends ArtistKey>{

	public T findById (Long id);
	public T findByName (String value);
}
