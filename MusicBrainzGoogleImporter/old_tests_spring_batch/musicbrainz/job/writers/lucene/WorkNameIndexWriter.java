package org.nanotek.musicbrainz.job.writers.lucene;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.WorkName;
import org.nanotek.lucene.template.base.BaseTemplate;
import org.nanotek.lucene.template.base.WorkNameTemplate;
import org.springframework.batch.item.ItemWriter;

public class WorkNameIndexWriter implements ItemWriter<WorkName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(WorkNameIndexWriter.class);
	private BaseTemplate<WorkName> workNameTemplate;
	
	@Override
	public void write(List<? extends WorkName> items) throws Exception {
		log.info("WRITE Method TrackNameIndexWriter");
		for (WorkName workName : items) 
			indexWriter.addDocument(workNameTemplate.createTemplate(workName));
	}

	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	public BaseTemplate<WorkName> getWorkNameTemplate() {
		return workNameTemplate;
	}

	public void setWorkNameTemplate(BaseTemplate<WorkName> workNameTemplate) {
		this.workNameTemplate = workNameTemplate;
	}
	
}
