package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class ReleasePackaging implements Base<String>{

	private String id; 
	private String name; 
	
	public ReleasePackaging() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
