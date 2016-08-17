package org.nanotek.dao.spring.impl;

import java.util.List;

import org.nanotek.beans.ArtistCreditName;
import org.nanotek.dao.spring.ArtistCreditNameDAO;

public class ArtistCreditNameDAOImpl extends GeneralPurposeDAO<ArtistCreditName> implements ArtistCreditNameDAO<ArtistCreditName>{

	@Override
	public List<ArtistCreditName> loadAll() {
		return getHibernateTemplate().loadAll(clazz);
	}
	
	
	public ArtistCreditName findById (String id)
	{ 
		return (ArtistCreditName) getHibernateTemplate().get(clazz, id);
	}

}
