package org.nanotek.dao.spring.impl;

import java.util.List;

import org.nanotek.beans.ArtistKey;
import org.nanotek.dao.spring.ArtistDAO;

public class ArtistDAOImpl extends GeneralPurposeDAO<ArtistKey> implements ArtistDAO<ArtistKey>{

	@Override
	public List<ArtistKey> loadAll() {
		return getHibernateTemplate().loadAll(clazz);
	}
	
	public ArtistKey findById (Long id)
	{ 
		return (ArtistKey) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public ArtistKey findByName(String value) {
		return null;
	}
}
