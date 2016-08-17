package org.nanotek.dao.spring.impl;

import org.nanotek.beans.Label;
import org.nanotek.dao.spring.LabelDAO;

public class LabelDAOImpl extends GeneralPurposeDAO<Label> implements LabelDAO<Label>{

	public Label findById (Long id)
	{ 
		return (Label) getHibernateTemplate().get(clazz, id);
	}

}
