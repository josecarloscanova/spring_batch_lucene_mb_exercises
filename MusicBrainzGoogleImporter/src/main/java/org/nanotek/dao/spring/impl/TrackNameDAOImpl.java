package org.nanotek.dao.spring.impl;

import org.nanotek.beans.TrackName;
import org.nanotek.dao.spring.TrackNameDAO;

public class TrackNameDAOImpl extends GeneralPurposeDAO<TrackName> implements TrackNameDAO<TrackName>{

	public TrackName findById (String id)
	{ 
		return (TrackName) getHibernateTemplate().get(clazz, id);
	}

}
