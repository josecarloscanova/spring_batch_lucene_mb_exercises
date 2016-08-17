package org.nanotek.lucene.query.result;

import java.util.List;

import org.apache.lucene.search.TopDocs;

@SuppressWarnings("serial")
public class CompositeQueryResult <T extends List<SimpleQueryResult<?,?>>> extends AbstractQueryResult<T> {
	
	protected TopDocs topDocs; 
	
	public CompositeQueryResult (T result) 
	{ 
		this.result = result;
	}
	
	public TopDocs getTopDocs() {
		return topDocs;
	}
	
	public void setTopDocs(TopDocs topDocs) {
		this.topDocs = topDocs;
	}
	
}
