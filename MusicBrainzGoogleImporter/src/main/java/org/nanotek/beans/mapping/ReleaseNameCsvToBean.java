package org.nanotek.beans.mapping;

import org.nanotek.beans.ReleaseName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ReleaseNameCsvToBean extends CsvToBean< ColumnPositionMappingStrategy<ReleaseName> , ReleaseName> {

	public ReleaseNameCsvToBean() {
		super();
	}

}
