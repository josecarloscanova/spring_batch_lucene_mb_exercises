package org.nanotek.musicbrainz.job.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.dao.spring.ArtistCreditNameDAO;
import org.springframework.batch.item.ItemWriter;

public class ArtistCreditNameWriter implements ItemWriter<ArtistCreditName> {

	private ArtistCreditNameDAO<ArtistCreditName> dao; 
	
	public ArtistCreditNameWriter() {}
	private Log log = LogFactory.getLog(ArtistCreditNameWriter.class);
	
	public ArtistCreditNameDAO<ArtistCreditName> getDao() {
		return dao;
	}

	public void setDao(ArtistCreditNameDAO<ArtistCreditName> dao) {
		this.dao = dao;
	}

	@Override
	public void write(List<? extends ArtistCreditName> items) throws Exception {
		for (ArtistCreditName item : items)
			dao.persist(item);
	}

}
