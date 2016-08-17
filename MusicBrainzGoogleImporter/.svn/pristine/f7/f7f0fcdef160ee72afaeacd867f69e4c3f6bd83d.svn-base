package org.nanotek.musicbrainz.job.readers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.mapping.ArtistCreditCsvToBean;
import org.nanotek.beans.mapping.ArtistCreditMapping;
import org.nanotek.indexer.util.key.KeyServiceFactory;
import org.nanotek.jobs.GenericReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import au.com.bytecode.opencsv.CSVReader;

public class ArtistCreditReader extends GenericReader{

	protected String fileStr; 
	protected List<Base<?>> readList; 
	protected CSVReader reader;
	protected ArtistCreditMapping itemMapping;
	protected ArtistCreditCsvToBean csvMap;
	protected KeyServiceFactory keyServiceFactory;

	private Log log = LogFactory.getLog(ArtistCreditReader.class);
	
	public ArtistCreditReader() 
	{ 
		readList = new ArrayList<Base<?>>();
	}
	
	@Override
	public Base<?> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		String [] nextLine;
		ArtistCredit artistCredit = null;
		if ((nextLine = reader.readNext()) != null) {
			artistCredit = csvMap.processLine(getItemMapping(), nextLine);
		}
		return artistCredit;
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

	public ArtistCreditMapping getItemMapping() {
		return itemMapping;
	}

	public void setItemMapping(ArtistCreditMapping itemMapping) {
		this.itemMapping = itemMapping;
	}

	public ArtistCreditCsvToBean getCsvMap() {
		return csvMap;
	}

	public void setCsvMap(ArtistCreditCsvToBean csvMap) {
		this.csvMap = csvMap;
	}

	public KeyServiceFactory getKeyServiceFactory() {
		return keyServiceFactory;
	}

	public void setKeyServiceFactory(KeyServiceFactory keyServiceFactory) {
		this.keyServiceFactory = keyServiceFactory;
	} 
	
}
