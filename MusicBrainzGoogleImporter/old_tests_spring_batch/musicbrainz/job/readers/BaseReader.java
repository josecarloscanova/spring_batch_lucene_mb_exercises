package org.nanotek.musicbrainz.job.readers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.jobs.GenericReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
//import com.ibatis.common.logging.LogFactory;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.CSVReader;
//import org.slf4j.Logger;

public class BaseReader extends GenericReader{

	protected String fileStr; 
	protected List<Base<?>> readList; 
	protected CSVReader reader;
	protected ColumnPositionMappingStrategy<Base<?>> itemMapping;
	protected CsvToBean<Base<?>> csvMap;
	private  Log log = LogFactory.getLog(BaseReader.class);
	
	public BaseReader() 
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
			log.debug(base.toString());
		}
		return base;
	}

	public ColumnPositionMappingStrategy<Base<?>> getItemMapping() {
		return itemMapping;
	}

	public void setItemMapping(
			ColumnPositionMappingStrategy<Base<?>> itemMapping) {
		this.itemMapping = itemMapping;
	}

	public CsvToBean<Base<?>> getCsvMap() {
		return csvMap;
	}

	public void setCsvMap(CsvToBean<Base<?>> csvMap) {
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
