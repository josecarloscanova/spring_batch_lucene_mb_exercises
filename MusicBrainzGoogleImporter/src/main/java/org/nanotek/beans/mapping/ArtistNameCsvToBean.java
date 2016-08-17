package org.nanotek.beans.mapping;

import org.nanotek.beans.ArtistName;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ArtistNameCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<ArtistName> , ArtistName> {

	public ArtistNameCsvToBean() {
		super();
	}

}
