package org.nanotek.dao.spring.impl;

import java.util.List;

import org.nanotek.beans.ArtistName;
import org.nanotek.dao.spring.ArtistNameDAO;

public class ArtistNameDAOImpl extends GeneralPurposeDAO<ArtistName> implements ArtistNameDAO<ArtistName>{

	public ArtistName findById (Long id)
	{ 
		return (ArtistName) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<?> findByName(String value) {
		String hql = "Select a from ArtistName a where a.name like ?";
		return  getHibernateTemplate().find(hql, value);
	}

}
