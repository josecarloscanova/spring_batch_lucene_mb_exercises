package org.nanotek.beans.mapping;

import org.nanotek.beans.ReleaseLabel;
import org.nanotek.beans.ReleaseName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ReleaseLabelCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<ReleaseLabel> , ReleaseLabel> {

	public ReleaseLabelCsvToBean() {
		super();
	}

}
