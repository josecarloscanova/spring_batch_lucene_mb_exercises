package org.nanotek.dao.spring;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseDAO<T> extends HibernateDaoSupport  {

	protected Class<T> clazz;  
	
	public BaseDAO() {
	}

	public BaseDAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(clazz);
	}

//	@Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW,isolation=Isolation.DEFAULT)
	@Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void persist(T object) {
		getHibernateTemplate().save(object);
	}

	@Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void update(T object) {
		getHibernateTemplate().update(object);
	}

	@Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void delete(T object) {
		getHibernateTemplate().delete(object);
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	

}
