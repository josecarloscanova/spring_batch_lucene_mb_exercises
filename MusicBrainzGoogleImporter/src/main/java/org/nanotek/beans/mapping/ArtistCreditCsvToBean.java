package org.nanotek.beans.mapping;

import org.nanotek.beans.ArtistCredit;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ArtistCreditCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<ArtistCredit> , ArtistCredit> {

	public ArtistCreditCsvToBean() {
		super();
	}

}
