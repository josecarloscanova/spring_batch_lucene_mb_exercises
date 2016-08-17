package org.nanotek.beans.mapping;

import org.nanotek.beans.Release;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ReleaseCsvToBean extends CsvToBean< ColumnPositionMappingStrategy<Release> , Release> {

	public ReleaseCsvToBean() {
		super();
	}

}
