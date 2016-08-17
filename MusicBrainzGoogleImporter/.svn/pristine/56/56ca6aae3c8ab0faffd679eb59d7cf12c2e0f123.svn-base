package org.nanotek.musicbrainz.job.readers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.beans.ArtistName;
import org.nanotek.beans.mapping.ArtistNameCsvToBean;
import org.nanotek.beans.mapping.ArtistNameMapping;
import org.nanotek.indexer.util.key.KeyServiceFactory;
import org.nanotek.jobs.GenericReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import au.com.bytecode.opencsv.CSVReader;

public class ArtistNameReader extends GenericReader{

	protected String fileStr; 
	protected List<Base<?>> readList; 
	protected CSVReader reader;
	protected ArtistNameMapping itemMapping;
	protected ArtistNameCsvToBean csvMap;
	protected KeyServiceFactory keyServiceFactory;

	private Log log = LogFactory.getLog(ArtistNameReader.class);
	
	public ArtistNameReader() 
	{ 
		readList = new ArrayList<Base<?>>();
	}
	
	@Override
	public Base<?> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		String [] nextLine;
		ArtistName artistName = null;
		if ((nextLine = reader.readNext()) != null) {
			artistName = csvMap.processLine(getItemMapping(), nextLine);
		}
		return artistName;
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

	public ArtistNameMapping getItemMapping() {
		return itemMapping;
	}

	public void setItemMapping(ArtistNameMapping itemMapping) {
		this.itemMapping = itemMapping;
	}

	public ArtistNameCsvToBean getCsvMap() {
		return csvMap;
	}

	public void setCsvMap(ArtistNameCsvToBean csvMap) {
		this.csvMap = csvMap;
	}

	public KeyServiceFactory getKeyServiceFactory() {
		return keyServiceFactory;
	}

	public void setKeyServiceFactory(KeyServiceFactory keyServiceFactory) {
		this.keyServiceFactory = keyServiceFactory;
	}

}
