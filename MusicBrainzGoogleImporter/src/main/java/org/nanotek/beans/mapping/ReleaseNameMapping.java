package org.nanotek.beans.mapping;

import org.nanotek.beans.ReleaseName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class ReleaseNameMapping extends ColumnPositionMappingStrategy<ReleaseName> {

	public ReleaseNameMapping() 
	{ 
		
		String [] columns = new String [3]; 
		columns[0] = "id";
		columns[1] = "name";
		columns[2] = "refCount";
		this.setColumnMapping(columns);
		
	}
	
}
