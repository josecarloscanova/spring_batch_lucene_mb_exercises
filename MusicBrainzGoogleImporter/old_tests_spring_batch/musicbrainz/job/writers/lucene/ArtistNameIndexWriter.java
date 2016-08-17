package org.nanotek.musicbrainz.job.writers.lucene;

import static org.apache.lucene.document.LongField.TYPE_STORED;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
//import org.apache.lucene.document.NumericField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.ArtistName;
import org.springframework.batch.item.ItemWriter;

/**
 * A Writer Class which performs that construction of the Document which will be added on a Lucene Instance, 
 * it will delegate on future to a template builder based on LuceneTemplateBuilder interface. 
 * 
 * @author josecanovamauger
 *
 */
public class ArtistNameIndexWriter implements ItemWriter<ArtistName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(ArtistNameIndexWriter.class);
	
	@Override
	public void write(List<? extends ArtistName> items) throws Exception {
		for (ArtistName artistName:items){ 
			try { 
				indexWriter.addDocument(createTemplate(artistName));
			}catch (Exception ex) 
			{ 
				log.error("PROBLEMA ADICIONANDO DOCUMENTO",ex);
				throw ex;
			}
		}
	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	public  Document createTemplate(ArtistName artistName) throws Exception {

		Document doc = new Document();

		LongField wordField = new LongField("id", artistName.getId(),TYPE_STORED);  
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(wordField);

		StringField nameField = new StringField("name", artistName.getName(), Store.YES); 
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(nameField);

		LongField modifiedField = new LongField("modified" , new Date().getTime() , TYPE_STORED); //$NON-NLS-1$
//		modifiedField.setLongValue(new Date().getTime());
		doc.add(modifiedField);

		return doc;
	}
}
