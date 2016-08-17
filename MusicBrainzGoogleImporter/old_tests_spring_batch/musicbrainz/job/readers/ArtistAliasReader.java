package org.nanotek.musicbrainz.job.readers;

import java.util.ArrayList;
import java.util.List;

import org.nanotek.Base;
import org.nanotek.beans.mapping.ArtistAliasCsvToBean;
import org.nanotek.beans.mapping.ArtistAliasMapping;
import org.nanotek.jobs.GenericReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import au.com.bytecode.opencsv.CSVReader;

public class ArtistAliasReader extends GenericReader{

	protected String fileStr; 
	protected List<Base<?>> readList; 
	protected CSVReader reader;
	protected ArtistAliasMapping itemMapping;
	protected ArtistAliasCsvToBean csvMap;
	
	public ArtistAliasReader() 
	{ 
		readList = new ArrayList<Base<?>>();
	}
	
	@Override
	public Base<?> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
//		char separator = '\t';
//		CSVReader reader = new CSVReader(new FileReader(fileStr), separator);
		String [] nextLine;
		Base<?> base =null;
		if ((nextLine = reader.readNext()) != null) {
			base = csvMap.processLine(getItemMapping(), nextLine);
		}
//		reader.close();
		return base;
	}

	public ArtistAliasMapping getItemMapping() {
		return itemMapping;
	}

	public void setItemMapping(
			ArtistAliasMapping itemMapping) {
		this.itemMapping = itemMapping;
	}

	public ArtistAliasCsvToBean getCsvMap() {
		return csvMap;
	}

	public void setCsvMap(ArtistAliasCsvToBean csvMap) {
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
