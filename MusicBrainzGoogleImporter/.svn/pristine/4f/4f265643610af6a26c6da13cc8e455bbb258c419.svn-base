package org.nanotek.musicbrainz.job.writers.database;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.beans.LabelName;
import org.nanotek.dao.spring.LabelNameDAO;
import org.springframework.batch.item.ItemWriter;

public class LabelNameWriter<T extends LabelName> implements ItemWriter<LabelName> {

	private LabelNameDAO<LabelName> dao; 
	
	public LabelNameWriter() {}
	private Log log = LogFactory.getLog(LabelNameWriter.class);
	
	public LabelNameDAO<LabelName> getDao() {
		return dao;
	}

	public void setDao(LabelNameDAO<LabelName> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends LabelName> items) throws Exception {
		for (Base<?> item : items)
			dao.persist(item);
	}

}
