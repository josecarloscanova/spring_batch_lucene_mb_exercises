package org.nanotek.musicbrainz.job.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.beans.ReleaseName;
import org.nanotek.dao.spring.ReleaseNameDAO;
import org.springframework.batch.item.ItemWriter;

public class ReleaseNameWriter<T extends ReleaseName> implements ItemWriter<ReleaseName> {

	private ReleaseNameDAO<ReleaseName> dao; 
	
	public ReleaseNameWriter() {}
	private Log log = LogFactory.getLog(ReleaseNameWriter.class);
	
	public ReleaseNameDAO<ReleaseName> getDao() {
		return dao;
	}

	public void setDao(ReleaseNameDAO<ReleaseName> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends ReleaseName> items) throws Exception {
		for (ReleaseName item : items)
			dao.persist(item);
	}

}
