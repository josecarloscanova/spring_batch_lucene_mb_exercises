package org.nanotek.beans.mapping;

import org.nanotek.beans.Medium;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class MediumCsvToBean extends CsvToBean< ColumnPositionMappingStrategy<Medium> , Medium> {

	public MediumCsvToBean() {
		super();
	}

}
