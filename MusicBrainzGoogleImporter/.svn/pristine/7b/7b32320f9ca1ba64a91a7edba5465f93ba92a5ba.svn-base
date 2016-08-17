package org.nanotek.musicbrainz.job.writers.lucene;

import static org.apache.lucene.document.LongField.TYPE_STORED;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
//import org.apache.lucene.document.NumericField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.ArtistKey;
import org.nanotek.beans.ArtistName;
import org.nanotek.beans.Recording;
import org.nanotek.beans.Track;
import org.nanotek.beans.TrackName;
import org.nanotek.dao.spring.ArtistCreditDAO;
import org.nanotek.dao.spring.ArtistCreditNameDAO;
import org.nanotek.dao.spring.ArtistNameDAO;
import org.nanotek.dao.spring.RecordingDAO;
import org.nanotek.dao.spring.TrackDAO;
import org.nanotek.dao.spring.TrackNameDAO;
import org.springframework.batch.item.ItemWriter;

/**
 * REVIEW: This class shall follow the same pattern of the LuceneTemplateBuilder. 
 * 
 * @author josecanovamauger
 *
 */
public class TrackIndexWriter implements ItemWriter<List<Track>> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(TrackIndexWriter.class);
	private TrackDAO<Track> trackDAO; 
	private TrackNameDAO<TrackName> trackNameDAO; 
	private RecordingDAO<Recording> recordingDAO; 

	@Override
	public void write(List<? extends List<Track>> tracksItems) throws Exception {
		try{
			Document document = null;
			log.debug("STARTED QUERY DB :"+new Date().getTime());
			for (List<Track> tracks:tracksItems){ 
				for (Track track : tracks){ 
					
					document = new Document(); 
//					addTrack(document , track);
					TrackName trackName = trackNameDAO.findById(track.getName().toString());
					addTrackName(document , trackName);
//					Recording recording = recordingDAO.findById(track.getRecording());
//					addRecording (document , recording);
					indexWriter.addDocument(document);
				}
			}
			log.debug("FINISHED QUERY DB :"+new Date().getTime());
		}catch (Exception ex) 
		{ 
			log.error("PROBLEMA ADICIONANDO DOCUMENTO",ex);
			throw ex;
		}

	}

	private void addRecording(Document document, Recording recording) {
		LongField wordField = new LongField("recordingID", recording.getId() ,   TYPE_STORED );  
//		wordField.setLongValue(recording.getId());
//		wordField.setOmitNorms(true);
		document.add(wordField);
	}

	private void addTrackName(Document document, TrackName trackName) {
		StringField wordField = new StringField("trackName", trackName.getPage(),Store.YES); 
//		wordField.setOmitNorms(true);
		document.add(wordField);
	}

//	private void addTrack(Document document, Track track) {
//		
//		Field wordField = new Field("trackID", track.getId(), Field.Store.YES, Field.Index.NO); //$NON-NLS-1$ //$NON-NLS-2$
//		wordField.setOmitNorms(true);
//		document.add(wordField);
//
//		wordField = new Field("creditID", track.getArtistCredit(), Field.Store.YES, Field.Index.NO); //$NON-NLS-1$ //$NON-NLS-2$
//		wordField.setOmitNorms(true);
//		document.add(wordField);
//
//		wordField = new Field("recordingID", track.getRecording(), Field.Store.YES, Field.Index.NO); //$NON-NLS-1$ //$NON-NLS-2$
//		wordField.setOmitNorms(true);
//		document.add(wordField);
//
//		wordField = new Field("trackNameID", track.getName(), Field.Store.YES, Field.Index.NO); //$NON-NLS-1$ //$NON-NLS-2$
//		wordField.setOmitNorms(true);
//		document.add(wordField);
//
//	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	public TrackNameDAO<TrackName> getTrackNameDAO() {
		return trackNameDAO;
	}

	public void setTrackNameDAO(TrackNameDAO<TrackName> trackNameDAO) {
		this.trackNameDAO = trackNameDAO;
	}

	public TrackDAO<Track> getTrackDAO() {
		return trackDAO;
	}

	public void setTrackDAO(TrackDAO<Track> trackDAO) {
		this.trackDAO = trackDAO;
	}

	public RecordingDAO<Recording> getRecordingDAO() {
		return recordingDAO;
	}

	public void setRecordingDAO(RecordingDAO<Recording> recordingDAO) {
		this.recordingDAO = recordingDAO;
	}


}
