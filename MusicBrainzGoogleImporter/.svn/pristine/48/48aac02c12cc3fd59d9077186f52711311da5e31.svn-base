package org.nanotek.lucene.query.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.nanotek.Base;
import org.nanotek.lucene.query.result.ScoreDocBase;
import org.nanotek.lucene.query.result.ScoreDocument;

/**
 * Represents a simple result after performing a query on a 
 * BackEnd System, (In case Lucene). 
 * 
 * @author java-eclipse
 *
 * @param <K>
 */
@SuppressWarnings("serial")
public class ResultBase<K extends Serializable> implements Base<K>{

	  /** The score of this document for the query. */
	protected float score;

	  /** A hit document's number.
	   * @see IndexSearcher#doc(int) */
	protected int doc;

	  /** Only set by {@link TopDocs#merge} */
	protected int shardIndex;
	
	private Map<?,?> resultMap;

	private K id; 
	
	
	public ResultBase (K id )
	{ 
		this.id = id; 
		resultMap = new HashMap<>();
	}
	
	
	
	@Override
	public K getId() {
		return id;
	}

	@Override
	public void setId(K id) {
		throw new RuntimeException ("Not allowed change the id at Runtime");
	}
	  
	public Map<?, ?> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getDoc() {
		return doc;
	}

	public void setDoc(int doc) {
		this.doc = doc;
	}

	public int getShardIndex() {
		return shardIndex;
	}

	public void setShardIndex(int shardIndex) {
		this.shardIndex = shardIndex;
	}

}
