package org.nanotek.query.event;

import org.nanotek.Base;
import org.nanotek.lucene.query.result.ScoreDocBase;
import org.nanotek.query.QueryResult;

@SuppressWarnings("serial")
public class QueryResultBase<T> implements Base<QueryResult<?>> {

	QueryResult<?> id; 
	ScoreDocBase scoreDocBase; 
	
	
	public QueryResultBase() {
	}
	
	@Override
	public QueryResult<?> getId() {
		return id;
	}

	@Override
	public void setId(QueryResult<?> id) {
		this.id = id;
	}

	public ScoreDocBase getScoreDocBase() {
		return scoreDocBase;
	}

	public void setScoreDocBase(ScoreDocBase scoreDocBase) {
		this.scoreDocBase = scoreDocBase;
	}

}
