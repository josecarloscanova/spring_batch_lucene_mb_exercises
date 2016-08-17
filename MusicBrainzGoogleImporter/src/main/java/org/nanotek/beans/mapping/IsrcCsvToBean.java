package org.nanotek.beans.mapping;

import org.nanotek.beans.Isrc;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class IsrcCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<Isrc> , Isrc> {

	public IsrcCsvToBean() {
		super();
	}

}
