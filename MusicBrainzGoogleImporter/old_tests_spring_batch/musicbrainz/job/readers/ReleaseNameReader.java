package org.nanotek.musicbrainz.job.readers;

import java.util.ArrayList;
import java.util.List;

import org.nanotek.Base;
import org.nanotek.beans.mapping.ReleaseNameCsvToBean;
import org.nanotek.beans.mapping.ReleaseNameMapping;
import org.nanotek.jobs.GenericReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import au.com.bytecode.opencsv.CSVReader;

public class ReleaseNameReader extends GenericReader{

	protected String fileStr; 
	protected List<Base<?>> readList; 
	protected CSVReader reader;
	protected ReleaseNameMapping itemMapping;
	protected ReleaseNameCsvToBean csvMap;
	
	public ReleaseNameReader() 
	{ 
		readList = new ArrayList<Base<?>>();
	}
	
	@Override
	public Base<?> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		String [] nextLine;
		Base<?> base = null;
		if ((nextLine = reader.readNext()) != null) {
			base = csvMap.processLine(getItemMapping(), nextLine);
			return base;
		}
		return base;
	}

	public ReleaseNameMapping getItemMapping() {
		return itemMapping;
	}

	public void setItemMapping(
			ReleaseNameMapping itemMapping) {
		this.itemMapping = itemMapping;
	}

	public ReleaseNameCsvToBean getCsvMap() {
		return csvMap;
	}

	public void setCsvMap(ReleaseNameCsvToBean csvMap) {
		this.csvMap = csvMap;
	}

	public String getFileStr() {
		return fileStr;
	}

	public void setFileStr(String fileStr) {
		this.fileStr = fileStr;
	}

	public List<Base<?>> getReadList() {
		return readList;
	}

	public void setReadList(List<Base<?>> readList) {
		this.readList = readList;
	}

	public CSVReader getReader() {
		return reader;
	}

	public void setReader(CSVReader reader) {
		this.reader = reader;
	} 
	
}
