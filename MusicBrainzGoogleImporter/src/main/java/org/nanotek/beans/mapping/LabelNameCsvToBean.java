package org.nanotek.beans.mapping;

import org.nanotek.beans.LabelName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class LabelNameCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<LabelName> , LabelName> {

	public LabelNameCsvToBean() {
		super();
	}

}
