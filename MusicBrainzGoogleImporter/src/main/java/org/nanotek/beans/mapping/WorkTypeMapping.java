package org.nanotek.beans.mapping;

import org.nanotek.beans.WorkType;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class WorkTypeMapping extends ColumnPositionMappingStrategy<WorkType> {

	public WorkTypeMapping() 
	{ 
		String [] columns = new String [2]; 
		columns[0] = "id";
		columns[1] = "name";
		this.setColumnMapping(columns);
	}
	
}
