package org.nanotek.musicbrainz.job.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.lucene.job.readers.ITrackDAOReader;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class FilePageChunkListener implements ChunkListener {

	private Log log = LogFactory.getLog(FilePageChunkListener.class);
	private Integer startPage = 0; 
	private Integer numRecords = 1000; 
	private ITrackDAOReader trackDAOReader; 
	
	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(Integer numRecords) {
		this.numRecords = numRecords;
	}

	@Override
	public void beforeChunk(ChunkContext context) {
		log.debug("STARTING BEFORE CHUNK " + startPage + " | " + numRecords);
		trackDAOReader.setMaxResults(numRecords);
		trackDAOReader.setStartRecord(startPage);
	}

	@Override
	public void afterChunk(ChunkContext context) {
		startPage = startPage + numRecords;
		log.debug("FINISHED AFTER CHUNK " + startPage );
	}

	public ITrackDAOReader getTrackDAOReader() {
		return trackDAOReader;
	}

	public void setTrackDAOReader(
			ITrackDAOReader artistCreditNameReader) {
		this.trackDAOReader = artistCreditNameReader;
	}

	@Override
	public void afterChunkError(ChunkContext context) {
	}
}
