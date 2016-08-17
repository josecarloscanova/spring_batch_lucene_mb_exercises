package org.nanotek.beans.mapping;

import org.nanotek.beans.WorkName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class WorkNameCsvToBean extends CsvToBean< ColumnPositionMappingStrategy<WorkName>  , WorkName> {

	public WorkNameCsvToBean() {
		super();
	}

}
