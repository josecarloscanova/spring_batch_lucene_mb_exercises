package org.nanotek.beans.mapping;

import org.nanotek.beans.Work;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class WorkMapping extends ColumnPositionMappingStrategy<Work> {

	public WorkMapping() 
	{ 
		
		String [] columns = new String [9]; 
		columns[0] = "id";
		columns[1] = "gid";
		columns[2] = "type";
		columns[3] = "name";
		columns[4] = "iswc";
		columns[5] = null;
		columns[6] = null;
		this.setColumnMapping(columns);
		
	}
	
}
