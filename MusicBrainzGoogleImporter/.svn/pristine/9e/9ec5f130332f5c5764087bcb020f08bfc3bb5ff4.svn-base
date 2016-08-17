package org.nanotek.musicbrainz.job.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.beans.TrackName;
import org.nanotek.dao.spring.TrackNameDAO;
import org.springframework.batch.item.ItemWriter;

public class TrackNameWriter<T extends TrackName> implements ItemWriter<TrackName> {

	private TrackNameDAO<TrackName> dao; 
	
	public TrackNameWriter() {}
	private Log log = LogFactory.getLog(TrackNameWriter.class);
	
	public TrackNameDAO<TrackName> getDao() {
		return dao;
	}

	public void setDao(TrackNameDAO<TrackName> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends TrackName> items) throws Exception {
		for (TrackName item : items)
			dao.persist(item);
	}

}
