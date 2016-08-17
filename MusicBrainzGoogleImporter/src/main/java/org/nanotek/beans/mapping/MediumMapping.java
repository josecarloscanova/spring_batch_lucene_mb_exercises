package org.nanotek.beans.mapping;

import org.nanotek.beans.Medium;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class MediumMapping extends ColumnPositionMappingStrategy<Medium>{

	public MediumMapping() 
	{ 
		String [] columns = new String [9]; 
		columns[0] = "id";
		columns[2] = "trackList";
		columns[3] = "release";
		columns[4] = "position";
		columns[5] = "format";
		columns[6] = "name";
		columns[7] = null;
		columns[8] = null;
		this.setColumnMapping(columns);
	}
}
