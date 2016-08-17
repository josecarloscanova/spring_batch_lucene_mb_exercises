package org.nanotek.musicbrainz.job.writers.lucene;

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
import org.nanotek.beans.LabelName;
import org.springframework.batch.item.ItemWriter;

public class LabelNameIndexWriter implements ItemWriter<LabelName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(LabelNameIndexWriter.class);
	
	@Override
	public void write(List<? extends LabelName> items) throws Exception {
		for (LabelName item:items)
			indexWriter.addDocument(createTemplate(item));
		log.info("WRITE Method LabelNameIndexWriter");
	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	public  Document createTemplate(LabelName labelName) throws Exception {

		Document doc = new Document();


		LongField idField = new LongField("id", labelName.getId() , Store.YES); 
//		wordField.setLongValue(labelName.getId());
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(idField);

		StringField nameField = new StringField("name", labelName.getName(),  Store.YES); 
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(nameField);

		LongField modifiedField = new LongField("modified" , new Date().getTime() , Store.YES); 
//		modifiedField.setLongValue(new Date().getTime());
		doc.add(modifiedField);

		return doc;
	}
}
