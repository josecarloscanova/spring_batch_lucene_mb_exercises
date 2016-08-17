package org.nanotek.base.region;

import java.util.HashMap;
import java.util.Map;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class RegionMap<K extends Number> implements Base<K> {

	private K id; 
	private String designation; 
	private Map<String,?> region; 
	
	public RegionMap() {
		region = new HashMap<String,Base<?>>();
	}
	
	public RegionMap(String designation) {
		super();
		this.designation = designation;
	}

	public RegionMap(K id) {
		super();
		this.id = id;
	}

	public RegionMap(K id, String designation) {
		super();
		this.id = id;
		this.designation = designation;
		region = new HashMap<String,Base<?>>();
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public K getId() {
		return id;
	}

	@Override
	public void setId(K id) {
		this.id  = id; 
	}

	public Map<String, ?> getRegion() {
		return region;
	}

	public void setRegion(Map<String, ?> region) {
		this.region = region;
	}
}
