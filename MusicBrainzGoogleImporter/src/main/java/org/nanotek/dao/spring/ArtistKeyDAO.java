package org.nanotek.dao.spring;

import org.nanotek.beans.ArtistKey;

public interface ArtistKeyDAO<T extends ArtistKey>  {

	public T findById (String id);
}
