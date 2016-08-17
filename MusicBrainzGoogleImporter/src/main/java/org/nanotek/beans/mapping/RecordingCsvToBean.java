package org.nanotek.beans.mapping;

import org.nanotek.beans.Recording;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class RecordingCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<Recording> , Recording> {

	public RecordingCsvToBean() {
		super();
	}

}
