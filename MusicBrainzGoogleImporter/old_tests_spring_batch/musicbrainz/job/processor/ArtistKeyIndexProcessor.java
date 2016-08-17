package org.nanotek.musicbrainz.job.processor;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.AbstractField;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.ArtistKey;
import org.nanotek.beans.ArtistName;
import org.springframework.batch.item.ItemProcessor;

/**
 * @deprecated
 * @author josecanova
 *
 */
public class ArtistKeyIndexProcessor implements ItemProcessor<ArtistKey,ArtistKey> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(ArtistKeyIndexProcessor.class);
	

	@Override
	public ArtistKey process(final ArtistKey item) throws Exception {
		ArtistKey innerItem = item; 
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
	public  Document createTemplate(ArtistKey artistKey) throws Exception {

		Document doc = new Document();

		NumericField wordField = new NumericField("id", Field.Store.YES, true); //$NON-NLS-1$ //$NON-NLS-2$
		wordField.setLongValue(Long.parseLong(artistKey.getId()));
		wordField.setOmitTermFreqAndPositions(true);
		wordField.setOmitNorms(true);
		doc.add(wordField);

		NumericField anmeField = new NumericField("name", Field.Store.YES, true); //$NON-NLS-1$ //$NON-NLS-2$
		anmeField.setLongValue(artistKey.getNameId()); 
		anmeField.setOmitTermFreqAndPositions(true);
		anmeField.setOmitNorms(true);
		doc.add(anmeField);

		NumericField sortName = new NumericField("sortName", Field.Store.YES, true); //$NON-NLS-1$ //$NON-NLS-2$
		sortName.setLongValue(artistKey.getSortNameId());
		wordField.setOmitTermFreqAndPositions(true);
		wordField.setOmitNorms(true);
		doc.add(sortName);
		
		NumericField modifiedField = new NumericField("modified"); //$NON-NLS-1$
		modifiedField.setLongValue(new Date().getTime());
		doc.add(modifiedField);

		return doc;
	}

}
