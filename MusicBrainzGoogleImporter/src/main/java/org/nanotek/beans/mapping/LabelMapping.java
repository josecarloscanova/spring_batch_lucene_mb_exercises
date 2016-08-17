package org.nanotek.beans.mapping;

import org.nanotek.beans.Label;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class LabelMapping extends ColumnPositionMappingStrategy<Label> {

	public LabelMapping() 
	{ 
		
		String [] columns = new String [18]; 
		
		columns[0] = "id";
		columns[1] = "gid";
		columns[2] = "name";
		columns[3] = "sortName";
		columns[4] = "type";
		columns[5] = "labelCode";
		columns[6] = "country";
		columns[7] = "beginDateYear";
		columns[8] = "beginDateMonth";
		columns[9] = "beginDateDay";
		columns[10] = "endDateYear";
		columns[11] = "endDateMonth";
		columns[12] = "endDateDay";
		columns[13] = null;
		columns[14] = null;
		columns[15] = "ipiCode";
		columns[16] = null;
		columns[17] = null;
		
		this.setColumnMapping(columns);
		
	}
	
}
