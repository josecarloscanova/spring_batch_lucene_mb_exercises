package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class WorkName implements Base<Long> {
	
	private Long id; 
	private String name; 
	
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
