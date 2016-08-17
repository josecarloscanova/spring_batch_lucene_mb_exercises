package org.nanotek.musicbrainz.job.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.ReleaseName;
import org.nanotek.lucene.template.base.BaseTemplate;
import org.springframework.batch.item.ItemProcessor;

/**
 * @deprecated
 * @author josecanova
 *
 */
public class ReleaseNameIndexProcessor implements ItemProcessor<ReleaseName,ReleaseName> {

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(ReleaseNameIndexProcessor.class);
	private BaseTemplate<ReleaseName> releaseNameTemplate; 
	
	@Override
	public ReleaseName process(final ReleaseName item) throws Exception {
		ReleaseName innerItem = item; 
		try { 
			Document doc = releaseNameTemplate.createTemplate(innerItem);
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

	public BaseTemplate<ReleaseName> getReleaseNameTemplate() {
		return releaseNameTemplate;
	}

	public void setReleaseNameTemplate(BaseTemplate<ReleaseName> releaseNameTemplate) {
		this.releaseNameTemplate = releaseNameTemplate;
	}

}
