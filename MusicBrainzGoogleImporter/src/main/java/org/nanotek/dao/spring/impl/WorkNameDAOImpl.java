package org.nanotek.dao.spring.impl;

import org.nanotek.beans.WorkName;
import org.nanotek.dao.spring.WorkNameDAO;

public class WorkNameDAOImpl extends GeneralPurposeDAO<WorkName> implements WorkNameDAO<WorkName>{

	public WorkName findById (String id)
	{ 
		return (WorkName) getHibernateTemplate().get(clazz, id);
	}
	
}
