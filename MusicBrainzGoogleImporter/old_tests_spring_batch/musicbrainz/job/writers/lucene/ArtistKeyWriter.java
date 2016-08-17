package org.nanotek.musicbrainz.job.writers.lucene;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;

import static org.apache.lucene.document.LongField.TYPE_STORED;
import static org.apache.lucene.document.Field.Store;

//import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.ArtistKey;
import org.nanotek.beans.ArtistName;
import org.nanotek.dao.spring.ArtistCreditDAO;
import org.nanotek.dao.spring.ArtistCreditNameDAO;
import org.nanotek.dao.spring.ArtistNameDAO;
import org.springframework.batch.item.ItemWriter;

/**
 * A Writer Class which performs that construction of the Document which will be added on a Lucene Instance, 
 * it will delegate on future to a template builder based on LuceneTemplateBuilder interface. 
 * 
 * @author josecanovamauger
 *
 */
public class ArtistKeyWriter implements ItemWriter<List<ArtistCreditName>>{

	private IndexWriter indexWriter;
	private Log log = LogFactory.getLog(ArtistKeyWriter.class);
	private ArtistNameDAO<ArtistName> artistNameDAO; 
	private ArtistCreditDAO<ArtistCredit> artistCreditDAO; 
	private ArtistCreditNameDAO<ArtistCreditName> artistCreditNameDAO; 

	@Override
	public void write(List<? extends List<ArtistCreditName>> items) throws Exception {
		for (List<ArtistCreditName> artistKeys:items){ 
			System.err.println("ARTIST KEY READER DEBUG SIZE:" + artistKeys.size());
			try { 
				log.debug("ARTIST KEY READER DEBUG SIZE:" + artistKeys.size());
				for (ArtistCreditName key : artistKeys) { 
//					indexWriter.addDocument(createTemplate(key));
					ArtistName name = artistNameDAO.findById(key.getName().toString());
					if (name!=null) { 
						
						Document document = createTemplate(key , name);
						ArtistCredit artistCredit = artistCreditDAO.findById(key.getArtistCredit());
						addArtistCredit (document , artistCredit);
						indexWriter.addDocument(document);
//						List<ArtistCredit> artistCredits = artistCreditDAO.findByKeyId(key.getId());
//						//						 System.err.println(name.getName());
//						for (ArtistCredit artistCredit : artistCredits){ 
//							if (indexWriter !=null) 
//							{ 
//								Document document = createTemplate(artistCredit , name, key);
//								indexWriter.addDocument(document);
//							}else { 
//								System.err.println("INDEX WRITER NULL");
//								log.debug("INDEX WRITER NULL");
//							}
//						}
					}
				}
			}catch (Exception ex) 
			{ 
				log.error("PROBLEMA ADICIONANDO DOCUMENTO",ex);
				throw ex;
			}

		}
	}

	private Document addArtistCredit(Document document, ArtistCredit artistCredit) {
		LongField wordField = new LongField("artistCreditId", artistCredit.getId() , TYPE_STORED);
//		wordField.setLongValue(artistCredit.getId());//$NON-NLS-1$ //$NON-NLS-2$
//		wordField.setOmitNorms(true);
		document.add(wordField);
		return document;
	}

	/**
	 * REVIEW: Analyze the need to store the ID's on the Lucene Document or just index it for search 
	 * since the id's are stored on the database. 
	 * 
	 * @param artistCredit
	 * @param name
	 * @return a Lucene Document 
	 * @throws Exception
	 */
	private Document createTemplate(ArtistCreditName artistCredit, ArtistName name) throws Exception {
		
		Document document = createTemplate(name);

		StringField wordField = new StringField("creditNameId", artistCredit.getId(), Store.YES); 
//		wordField.setOmitNorms(true);
		document.add(wordField);

//		LongField creditId = new LongField("creditId", Field.Store.YES, true); 
		LongField creditId = new LongField("creditId", artistCredit.getArtistCredit() , TYPE_STORED ); 
//		creditId.setLongValue(artistCredit.getArtistCredit()); 
//		creditId.setOmitNorms(true);
		document.add(creditId);

//		LongField artistId = new LongField("artistId", Field.Store.YES, true); //$NON-NLS-1$ //$NON-NLS-2$
		LongField artistId = new LongField("artistId", artistCredit.getArtist(), TYPE_STORED ); 
//		artistId.setLongValue(artistCredit.getArtist()); 
//		artistId.setOmitNorms(true);
		document.add(artistId);
		
		LongField modifiedField = new LongField("modified" , new Date().getTime() , TYPE_STORED);  
//		modifiedField.setLongValue(new Date().getTime());
		document.add(modifiedField);

		return document;
	}


	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	private Document createTemplate(ArtistKey key) throws Exception {

		Document document = new Document();

		LongField wordField = new LongField("keyId", key.getKey() , TYPE_STORED); 
		wordField.setLongValue(key.getKey());
//		wordField.setOmitNorms(true);
		document.add(wordField);

		StringField gidField = new StringField("gid", key.getId(), Store.YES); 
//		gidField.setOmitNorms(true);
		document.add(gidField);

		LongField modifiedField = new LongField("modified" , new Date().getTime() , TYPE_STORED); 
//		modifiedField.setLongValue(new Date().getTime());
		document.add(modifiedField);

		return document;
	}

	/**
	 * This method is not correct. Ned a Fix on Future. 
	 * @param artistName
	 * @return
	 * @throws Exception
	 */
	public  Document createTemplate(ArtistName artistName) throws Exception {

		Document doc = new Document();
		StringField nameIdField = new StringField("nameId", artistName.getId().toString(), Store.YES);
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(nameIdField);

		StringField nameField= new  StringField ("name", artistName.getName(), Store.YES);
//		wordField.setOmitTermFreqAndPositions(true);
//		wordField.setOmitNorms(true);
		doc.add(nameField);

		return doc;
	}

	public ArtistNameDAO<ArtistName> getArtistNameDAO() {
		return artistNameDAO;
	}

	public void setArtistNameDAO(ArtistNameDAO<ArtistName> artistNameDAO) {
		this.artistNameDAO = artistNameDAO;
	}

	public ArtistCreditDAO<ArtistCredit> getArtistCreditDAO() {
		return artistCreditDAO;
	}

	public void setArtistCreditDAO(ArtistCreditDAO<ArtistCredit> artistCreditDAO) {
		this.artistCreditDAO = artistCreditDAO;
	}

	public ArtistCreditNameDAO<ArtistCreditName> getArtistCreditNameDAO() {
		return artistCreditNameDAO;
	}

	public void setArtistCreditNameDAO(
			ArtistCreditNameDAO<ArtistCreditName> artistCreditNameDAO) {
		this.artistCreditNameDAO = artistCreditNameDAO;
	}
}
