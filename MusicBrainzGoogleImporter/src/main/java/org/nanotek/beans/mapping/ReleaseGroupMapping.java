package org.nanotek.beans.mapping;

import org.nanotek.beans.ReleaseGroup;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class ReleaseGroupMapping extends ColumnPositionMappingStrategy<ReleaseGroup> {

	public ReleaseGroupMapping() 
	{ 
		String [] columns = new String [8]; 
		columns[0] = "id";
		columns[1] = "gid";
		columns[2] = "name";
		columns[3] = "artistCredit";
		columns[4] = "type";
		columns[6] = null;
		columns[7] = null;
		columns[7] = null;
		this.setColumnMapping(columns);
	}
	
}
