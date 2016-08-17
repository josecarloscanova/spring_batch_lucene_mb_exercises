package org.nanotek.beans.mapping;

import org.nanotek.beans.Track;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class TrackCsvToBean extends CsvToBean<ColumnPositionMappingStrategy<Track> , Track> {

	public TrackCsvToBean() {
		super();
	}

}
