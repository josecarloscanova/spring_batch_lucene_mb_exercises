package org.nanotek.musicbrainz.job.processor;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.TrackName;
import org.springframework.batch.item.ItemProcessor;

/**
 * @deprecated
 * @author josecanova
 *
 */
public class TrackNameIndexProcessor implements ItemProcessor<TrackName,TrackName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(TrackNameIndexProcessor.class);

	@Override
	public TrackName process(final TrackName item) throws Exception {
		TrackName innerItem = item;
		try { 
			Document doc = createTemplate(innerItem);
			indexWriter.addDocument(doc);
		}catch (Exception ex) 
		{ 
			log.error("PROBLEMA ADICIONANDO DOCUMENTO",ex);
		}
		return innerItem;
	}
	
	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	@SuppressWarnings("deprecation")
	public  Document createTemplate(TrackName artistName) throws Exception {

		Document doc = new Document();

		NumericField wordField = new NumericField("id",  Field.Store.YES, true); //$NON-NLS-1$ //$NON-NLS-2$
		wordField.setLongValue(artistName.getId());
		wordField.setOmitTermFreqAndPositions(true);
		wordField.setOmitNorms(true);
		doc.add(wordField);

		Field anmeField = new Field("name", artistName.getPage(), Field.Store.YES, Field.Index.ANALYZED); //$NON-NLS-1$ //$NON-NLS-2$
		wordField.setOmitTermFreqAndPositions(true);
		wordField.setOmitNorms(true);
		doc.add(anmeField);

		NumericField modifiedField = new NumericField("modified"); //$NON-NLS-1$
		modifiedField.setLongValue(new Date().getTime());
		doc.add(modifiedField);

		return doc;
	}

}
