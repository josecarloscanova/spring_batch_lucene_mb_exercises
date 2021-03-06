package org.nanotek.musicbrainz.job.writers.lucene;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
//import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.ReleaseName;
import org.nanotek.lucene.template.base.BaseTemplate;
import org.springframework.batch.item.ItemWriter;

public class ReleaseNameIndexWriter implements ItemWriter<ReleaseName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(ReleaseNameIndexWriter.class);
	private BaseTemplate<ReleaseName> releaseNameTemplate; 
	
	
	@Override
	public void write(List<? extends ReleaseName> items) throws Exception {
		log.info("WRITE Method ReleaseNameIndexWriter");
		for (ReleaseName releaseName : items) 
			indexWriter.addDocument(releaseNameTemplate.createTemplate(releaseName));
	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	

	public BaseTemplate<ReleaseName> getReleaseNameTemplate() {
		return releaseNameTemplate;
	}

	public void setReleaseNameTemplate(BaseTemplate<ReleaseName> releaseNameTemplate) {
		this.releaseNameTemplate = releaseNameTemplate;
	}
}
