package org.nanotek.musicbrainz.job.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.beans.WorkName;
import org.nanotek.dao.spring.WorkNameDAO;
import org.springframework.batch.item.ItemWriter;

public class WorkNameWriter<T extends WorkName> implements ItemWriter<WorkName> {

	private WorkNameDAO<WorkName> dao; 
	
	public WorkNameWriter() {}
	private Log log = LogFactory.getLog(WorkNameWriter.class);
	
	public WorkNameDAO<WorkName> getDao() {
		return dao;
	}

	public void setDao(WorkNameDAO<WorkName> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends WorkName> items) throws Exception {
		for (WorkName item : items)
			dao.persist(item);
	}

}
