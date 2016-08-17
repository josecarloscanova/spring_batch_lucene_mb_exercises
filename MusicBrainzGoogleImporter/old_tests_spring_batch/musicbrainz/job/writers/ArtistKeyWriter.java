package org.nanotek.musicbrainz.job.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.beans.ArtistKey;
import org.nanotek.dao.spring.ArtistDAO;
import org.springframework.batch.item.ItemWriter;

public class ArtistKeyWriter implements ItemWriter<Base<?>> {

	private ArtistDAO<ArtistKey> dao; 
	private Log log = LogFactory.getLog(ArtistKeyWriter.class);
	
	public ArtistKeyWriter() {}
	
	public ArtistDAO<ArtistKey> getDao() {
		return dao;
	}

	public void setDao(ArtistDAO<ArtistKey> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends Base<?>> items) throws Exception {
		for (Base<?> item : items)
			dao.persist(item);
	}

}
