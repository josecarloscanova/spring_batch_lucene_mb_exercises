package org.nanotek.beans.mapping;

import org.nanotek.beans.ArtistAlias;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ArtistAliasCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<ArtistAlias> , ArtistAlias> {

	public ArtistAliasCsvToBean() {
		super();
	}

}
