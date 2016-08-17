package org.nanotek.beans.mapping;

import org.nanotek.beans.ArtistKey;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ArtistKeyCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<ArtistKey> , ArtistKey> {

	public ArtistKeyCsvToBean() {
		super();
	}

}
