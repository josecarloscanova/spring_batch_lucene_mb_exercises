package org.nanotek.musicbrainz.job.writers.database;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.dao.DAO;
import org.springframework.batch.item.ItemWriter;

public class BaseWriter<T extends Base<?>> implements ItemWriter<Base<?>> {

	private DAO<Base<?>> dao; 
	
	public BaseWriter() {}
	private Log log = LogFactory.getLog(BaseWriter.class);
	
	public DAO<Base<?>> getDao() {
		return dao;
	}

	public void setDao(DAO<Base<?>> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends Base<?>> items) throws Exception {
		for (Base<?> item : items)
			dao.persist(item);
	}

}
