package org.nanotek.beans.mapping;

import org.nanotek.beans.ArtistCreditName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class ArtistCreditNameMapping extends ColumnPositionMappingStrategy<ArtistCreditName> {

	public ArtistCreditNameMapping() 
	{ 
		String [] columns = new String [5]; 
		columns[0] = "artistCredit";
		columns[1] = "position";
		columns[2] = "artist";
		columns[3] = "name";
		columns[4] = "joinPhrase";
		this.setColumnMapping(columns);
	}
	
}
