package org.nanotek.beans.mapping;

import org.nanotek.beans.Work;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class WorkCsvToBean extends CsvToBean< ColumnPositionMappingStrategy<Work>  , Work> {

	public WorkCsvToBean() {
		super();
	}

}
