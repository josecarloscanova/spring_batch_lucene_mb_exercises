package org.nanotek.dao.spring.impl;

import org.nanotek.beans.ArtistKey;
import org.nanotek.dao.spring.ArtistKeyDAO;

public class ArtistKeyDAOImpl extends GeneralPurposeDAO<ArtistKey> implements ArtistKeyDAO<ArtistKey>{

	public ArtistKey findById (String id)
	{ 
		return (ArtistKey) getHibernateTemplate().get(clazz, id);
	}

}
