package org.nanotek.beans.mapping;

import org.nanotek.beans.CdToc;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class CdTocCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<CdToc> , CdToc> {

	public CdTocCsvToBean() {
		super();
	}

}
