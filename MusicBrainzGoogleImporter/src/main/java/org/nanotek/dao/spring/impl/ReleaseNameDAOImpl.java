package org.nanotek.dao.spring.impl;

import org.nanotek.beans.ReleaseName;
import org.nanotek.dao.spring.ReleaseNameDAO;

public class ReleaseNameDAOImpl extends GeneralPurposeDAO<ReleaseName> implements ReleaseNameDAO<ReleaseName>{

	public ReleaseName findById (String id)
	{ 
		return (ReleaseName) getHibernateTemplate().get(clazz, id);
	}

	
}
