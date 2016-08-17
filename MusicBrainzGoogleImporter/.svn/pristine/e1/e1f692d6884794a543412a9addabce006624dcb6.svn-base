package org.nanotek.base;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class PageItemBase<K extends Number> implements Base<K> {

	private K id; 
	private Integer startRecord; 
	private Integer maxRecords; 
	
	public PageItemBase() {
	}
	
	public PageItemBase(K id) {
		this.id = id;
	}
	

	@Override
	public K getId() {
		return id;
	}

	@Override
	public void setId(K id) {
		this.id = id;
	}

	public Integer getStartRecord() {
		if (startRecord == null) return new Integer (0);
		return startRecord;
	}

	public void setStartRecord(Integer startRecord) {
		this.startRecord = startRecord;
	}

	public Integer getMaxRecords() {
		if (maxRecords == null) return new Integer (20);
		return maxRecords;
	}

	public void setMaxRecords(Integer maxRecords) {
		this.maxRecords = maxRecords;
	}

}
