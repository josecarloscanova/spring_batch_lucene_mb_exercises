package org.nanotek.dao.spring.impl;

import java.util.List;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.dao.spring.ArtistCreditDAO;

public class ArtistCreditDAOImpl extends GeneralPurposeDAO<ArtistCredit> implements ArtistCreditDAO<ArtistCredit>{

	public ArtistCredit findById (Long id)
	{ 
		return (ArtistCredit) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<ArtistCredit> findByKeyId(Long nameId) {
		// TODO Auto-generated method stub
		ArtistCredit artistCredit = new ArtistCredit();
		artistCredit.setArtistCreditId(nameId);
		return  ((List<ArtistCredit>) getHibernateTemplate().
				findByExample(artistCredit));
	}

}
