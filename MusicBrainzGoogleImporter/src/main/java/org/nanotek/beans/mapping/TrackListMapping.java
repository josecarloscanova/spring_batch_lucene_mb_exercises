package org.nanotek.beans.mapping;

import org.nanotek.beans.TrackList;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class TrackListMapping extends ColumnPositionMappingStrategy<TrackList> {

	public TrackListMapping() 
	{ 
		String [] columns = new String [3]; 
		columns[0] = "id";
		columns[1] = "count";
		columns[2] = null;
		this.setColumnMapping(columns);
	}
	
}
