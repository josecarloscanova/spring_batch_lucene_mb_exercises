package org.nanotek.musicbrainz.job.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.beans.ArtistName;
import org.nanotek.dao.spring.ArtistNameDAO;
import org.springframework.batch.item.ItemWriter;

public class ArtistNameWriter<T extends ArtistName> implements ItemWriter<ArtistName> {

	private ArtistNameDAO<ArtistName> dao; 
	
	public ArtistNameWriter() {}
	private Log log = LogFactory.getLog(ArtistNameWriter.class);
	
	public ArtistNameDAO<ArtistName> getDao() {
		return dao;
	}

	public void setDao(ArtistNameDAO<ArtistName> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends ArtistName> items) throws Exception {
		for (Base<?> item : items)
			dao.persist(item);
	}

}
