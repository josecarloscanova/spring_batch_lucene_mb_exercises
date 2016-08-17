package org.nanotek.beans.mapping;

import org.nanotek.beans.ArtistKey;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class ArtistKeyMapping extends ColumnPositionMappingStrategy<ArtistKey> {

	public ArtistKeyMapping() 
	{ 
		String [] columns = new String [17]; 
		columns[0] = "key";
		columns[1] = "gid";
		columns[2] = "nameId";
		columns[3] = "sortNameId";
		columns[4] = null;
		columns[5] = null;
		columns[6] = null;
		columns[7] = null;
		columns[8] = null;
		columns[9] = null;
		columns[10] = "typeId";
		columns[11] = "genderId";
		columns[12] = "countryId";
		columns[13] = null;
		columns[14] = null;
		columns[15] = null;
		columns[16] = null;
		this.setColumnMapping(columns);
	}
	
}
