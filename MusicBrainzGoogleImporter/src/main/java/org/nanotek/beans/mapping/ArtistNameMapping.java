package org.nanotek.beans.mapping;

import org.nanotek.beans.ArtistName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class ArtistNameMapping extends ColumnPositionMappingStrategy<ArtistName> {

	public ArtistNameMapping() 
	{ 
		String [] columns = new String [2]; 
		columns[0] = "id";
		columns[1] = "name";
		this.setColumnMapping(columns);
	}
	
}
