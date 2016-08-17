package org.nanotek.musicbrainz.job.writers.lucene;

import static org.apache.lucene.document.LongField.TYPE_STORED;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
//import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.TrackName;
import org.springframework.batch.item.ItemWriter;

/**
 * REVIEW: This class shall follow the same pattern of the LuceneTemplateBuilder. 
 * 
 * @author josecanovamauger
 *
 */
public class TrackNameIndexWriter implements ItemWriter<TrackName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(TrackNameIndexWriter.class);
	
	@Override
	public void write(List<? extends TrackName> items) throws Exception {
		log.info("WRITE Method TrackNameIndexWriter");
		for (TrackName releaseName : items) 
			indexWriter.addDocument(createTemplate(releaseName));
	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	public  Document createTemplate(TrackName trackName) throws Exception {

		Document doc = new Document();

		LongField wordField = new LongField("id", trackName.getId() , TYPE_STORED);  
		wordField.setLongValue(trackName.getId());
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(wordField);

		StringField nameField = new StringField("name", trackName.getPage(), Store.YES);  
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(nameField);

		LongField modifiedField = new LongField("modified" , new Date().getTime() , TYPE_STORED);  
//		modifiedField.setLongValue(new Date().getTime());
		doc.add(modifiedField);

		return doc;
	}
}
