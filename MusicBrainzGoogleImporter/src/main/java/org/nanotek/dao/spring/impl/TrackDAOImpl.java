package org.nanotek.dao.spring.impl;

import org.nanotek.beans.Track;
import org.nanotek.dao.spring.TrackDAO;

public class TrackDAOImpl extends GeneralPurposeDAO<Track> implements TrackDAO<Track>{

	public Track findById (String id)
	{ 
		return (Track) getHibernateTemplate().get(clazz, id);
	}
	
}
