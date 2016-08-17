package org.nanotek.lucene.query.result;

import java.io.Serializable;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class SimpleQueryResult<T extends ScoreDocument, K extends Serializable> extends AbstractQueryResult<T> implements Base<K>{

	protected K id; 
	protected String mimeType; 
	private T scoreDocument; 
	
	public SimpleQueryResult(){}

	public SimpleQueryResult(K id) {
		super();
		this.id = id;
	}

	public SimpleQueryResult(K id, T scoreDocument) {
		super();
		this.id = id;
		this.scoreDocument = scoreDocument;
	}
	
	@Override
	public K getId() {
		return id;
	}

	@Override
	public void setId(K id) {
		this.id = id;
	}
	
	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public T getScoreDocument() {
		return scoreDocument;
	}

	public void setScoreDocument(T scoreDocument) {
		this.scoreDocument = scoreDocument;
	}
	
}
