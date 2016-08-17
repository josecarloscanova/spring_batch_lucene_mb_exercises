package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class TrackName implements Base<Long> {

	private Long id;
	
	private String page;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
}
