package org.nanotek.beans.mapping;

import org.nanotek.beans.TrackName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class TrackCountMapping extends ColumnPositionMappingStrategy<TrackName> {

	public TrackCountMapping() 
	{ 
		String [] columns = new String [3]; 
		columns[0] = "id";
		columns[1] = "page";
		this.setColumnMapping(columns);
	}
	
}
