package org.nanotek.beans.mapping;

import org.nanotek.beans.WorkAlias;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class WorkAliasCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<WorkAlias> , WorkAlias> {

	public WorkAliasCsvToBean() {
		super();
	}

}
