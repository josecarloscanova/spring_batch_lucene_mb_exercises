package org.nanotek.dao.spring.impl;

import java.util.List;

import org.nanotek.beans.ArtistAlias;
import org.nanotek.dao.spring.ArtistAliasDAO;

public class ArtistAliasDAOImpl extends GeneralPurposeDAO<ArtistAlias> implements ArtistAliasDAO<ArtistAlias>{

	public ArtistAlias findById (Long id)
	{ 
		return (ArtistAlias) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<ArtistAlias> findByKeyId(Long nameId) {
		// TODO Auto-generated method stub
		ArtistAlias artistCredit = new ArtistAlias();
		artistCredit.setNameId(nameId);
		return  (List<ArtistAlias>) getHibernateTemplate().
				findByExample(artistCredit);
	}

}
