package org.nanotek.beans.mapping;

import org.nanotek.beans.Label;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class LabelCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<Label> , Label> {

	public LabelCsvToBean() {
		super();
	}

}
