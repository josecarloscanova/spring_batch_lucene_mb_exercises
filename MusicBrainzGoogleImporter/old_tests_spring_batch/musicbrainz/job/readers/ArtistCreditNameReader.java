package org.nanotek.musicbrainz.job.readers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.mapping.ArtistCreditNameCsvToBean;
import org.nanotek.beans.mapping.ArtistCreditNameMapping;
import org.nanotek.indexer.util.key.KeyServiceFactory;
import org.nanotek.jobs.GenericReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import au.com.bytecode.opencsv.CSVReader;

public class ArtistCreditNameReader extends GenericReader{

	protected String fileStr; 
	protected List<Base<?>> readList; 
	protected CSVReader reader;
	protected ArtistCreditNameMapping itemMapping;
	protected ArtistCreditNameCsvToBean csvMap;
	protected KeyServiceFactory keyServiceFactory;

	private Log log = LogFactory.getLog(ArtistCreditNameReader.class);
	
	public ArtistCreditNameReader() 
	{ 
		readList = new ArrayList<Base<?>>();
	}
	
	@Override
	public Base<?> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		String [] nextLine;
		ArtistCreditName artistCreditName = null;
		if ((nextLine = reader.readNext()) != null) {
			artistCreditName = csvMap.processLine(getItemMapping(), nextLine);
			UUID propID = (UUID) (keyServiceFactory).getKey(UUID.class);
			artistCreditName.setId(propID.toString());
		}
		return artistCreditName;
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


	public KeyServiceFactory getKeyServiceFactory() {
		return keyServiceFactory;
	}

	public void setKeyServiceFactory(KeyServiceFactory keyServiceFactory) {
		this.keyServiceFactory = keyServiceFactory;
	}

	public ArtistCreditNameMapping getItemMapping() {
		return itemMapping;
	}

	public void setItemMapping(ArtistCreditNameMapping itemMapping) {
		this.itemMapping = itemMapping;
	}

	public ArtistCreditNameCsvToBean getCsvMap() {
		return csvMap;
	}

	public void setCsvMap(ArtistCreditNameCsvToBean csvMap) {
		this.csvMap = csvMap;
	} 
	
}
