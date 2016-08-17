package org.nanotek.beans.mapping;

import org.nanotek.beans.TrackName;
import org.nanotek.beans.Url;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class UrlCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<Url> , Url> {

	public UrlCsvToBean() {
		super();
	}

}
