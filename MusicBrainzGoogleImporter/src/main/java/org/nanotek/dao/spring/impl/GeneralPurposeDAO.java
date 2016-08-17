package org.nanotek.dao.spring.impl;

import java.io.Serializable;
import java.util.List;

import org.nanotek.Base;
import org.nanotek.dao.DAO;
import org.nanotek.dao.DAOException;
import org.nanotek.dao.spring.BaseDAO;
import org.springframework.dao.DataAccessException;

@SuppressWarnings("unchecked")
public class GeneralPurposeDAO <T extends Base<?>> extends BaseDAO<T> implements DAO<T> {

	public GeneralPurposeDAO() {}

	
	public <I extends Serializable> Base<I> findById (I id)
	{ 
		return (Base<I>) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> listRecords(Integer firstResult, Integer maxResults) {
		try {
			return getHibernateTemplate().findByExample(getClazz().newInstance() , firstResult, maxResults);
		} catch (DataAccessException | InstantiationException
				| IllegalAccessException e) {
			throw new DAOException(e);
		}
	}

}
