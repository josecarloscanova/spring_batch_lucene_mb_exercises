package org.nanotek.beans.mapping;

import org.nanotek.beans.WorkType;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class WorkTypeCsvToBean extends CsvToBean< ColumnPositionMappingStrategy<WorkType> , WorkType> {

	public WorkTypeCsvToBean() {
		super();
	}

}
