package org.nanotek.beans.mapping;

import org.nanotek.beans.ReleaseName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class ReleaseLabelMapping extends ColumnPositionMappingStrategy<ReleaseName> {

	public ReleaseLabelMapping() 
	{ 
		
		String [] columns = new String [5]; 
		columns[0] = "id";
		columns[1] = "release";
		columns[2] = "label";
		columns[3] = "catalogNumber";
		columns[4] = null;
		this.setColumnMapping(columns);
		
	}
	
}
