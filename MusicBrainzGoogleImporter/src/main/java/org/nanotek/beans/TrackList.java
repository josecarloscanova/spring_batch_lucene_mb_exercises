package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class TrackList implements Base<Long> {

	private Long id; 
	private Long count; 
	
	@Override
	public Long getId() {
		return id;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
