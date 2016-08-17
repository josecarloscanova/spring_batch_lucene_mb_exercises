package org.nanotek.query;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class QueryBase implements Base<Long>{

	protected Long id;
	protected String query; 
	
	public QueryBase(String query)
	{ 
		this.query = query; 
		id = System.currentTimeMillis();
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
}
