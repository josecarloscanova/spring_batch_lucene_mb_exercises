package org.nanotek.beans.mapping;

import org.nanotek.beans.Language;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class LanguageCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<Language> , Language> {

	public LanguageCsvToBean() {
		super();
	}

}
