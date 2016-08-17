package org.nanotek.musicbrainz.job.processor;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.LabelName;
import org.springframework.batch.item.ItemProcessor;

/**
 * @deprecated
 * @author josecanova
 *
 */
public class LabelNameIndexProcessor implements ItemProcessor<LabelName,LabelName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(LabelNameIndexProcessor.class);

	@Override
	public LabelName process(final LabelName item) throws Exception {
		LabelName innerItem = item; 
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
	public  Document createTemplate(LabelName labelName) throws Exception {

		Document doc = new Document();

		NumericField wordField = new NumericField("id",  Field.Store.YES, true); //$NON-NLS-1$ //$NON-NLS-2$
		wordField.setLongValue(labelName.getId());
		wordField.setOmitTermFreqAndPositions(true);
		wordField.setOmitNorms(true);
		doc.add(wordField);

		Field anmeField = new Field("name", labelName.getName(), Field.Store.YES, Field.Index.ANALYZED); //$NON-NLS-1$ //$NON-NLS-2$
		wordField.setOmitTermFreqAndPositions(true);
		wordField.setOmitNorms(true);
		doc.add(anmeField);

		NumericField modifiedField = new NumericField("modified"); //$NON-NLS-1$
		modifiedField.setLongValue(new Date().getTime());
		doc.add(modifiedField);

		return doc;
	}

}
