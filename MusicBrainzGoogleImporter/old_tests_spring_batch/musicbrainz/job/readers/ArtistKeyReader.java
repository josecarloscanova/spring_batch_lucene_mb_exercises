package org.nanotek.musicbrainz.job.readers;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nanotek.Base;
import org.nanotek.beans.ArtistKey;
import org.nanotek.beans.mapping.ArtistKeyCsvToBean;
import org.nanotek.beans.mapping.ArtistKeyMapping;
import org.nanotek.indexer.util.key.KeyServiceFactory;
import org.nanotek.jobs.GenericReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import au.com.bytecode.opencsv.CSVReader;

public class ArtistKeyReader extends GenericReader{

	protected String fileStr; 
	protected List<Base<?>> readList; 
	protected CSVReader reader;
	protected ArtistKeyMapping itemMapping;
	protected ArtistKeyCsvToBean csvMap;
	protected KeyServiceFactory keyServiceFactory;

	private Log log = LogFactory.getLog(ArtistKeyReader.class);

	public ArtistKeyReader() 
	{ 
		readList = new ArrayList<Base<?>>();
	}

	@Override
	public Base<?> read() throws Exception, UnexpectedInputException,
	ParseException, NonTransientResourceException {
		String [] nextLine;
		ArtistKey artistKey =null;
		if ((nextLine = reader.readNext()) != null) {
//			replaceNilNull(nextLine);
			artistKey = csvMap.processLine(getItemMapping(), nextLine);
//			log.debug("LIST OBJECT " + nextLine);
//			UUID propID = (UUID) (keyServiceFactory).getKey(UUID.class);
//			artistKey.setId(propID.toString());
		}
		return artistKey;
	}

	private void replaceNilNull (final String [] array) throws IntrospectionException { 
		for (int i=0; i<array.length;i++) { 
			String val = array[i];
			if ("\\N".equals(val) || "N".equals(val)) { 
				Class<ArtistKey> clazz = itemMapping.getType(); 
				if (itemMapping.getColumnMapping()[i] !=null) { 
					PropertyDescriptor descriptor = new PropertyDescriptor (itemMapping.getColumnMapping()[i] , clazz);
					if (descriptor.getPropertyType().isInstance(0L) 
							|| descriptor.getPropertyType().isInstance(0D) 
							|| descriptor.getPropertyType().isInstance(0))
						array[i] = "0"; 
					else { 
						array[i] = ""; 
					}
				}
			}
		}
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

	public ArtistKeyMapping getItemMapping() {
		return itemMapping;
	}

	public void setItemMapping(ArtistKeyMapping itemMapping) {
		this.itemMapping = itemMapping;
	}

	public ArtistKeyCsvToBean getCsvMap() {
		return csvMap;
	}

	public void setCsvMap(ArtistKeyCsvToBean csvMap) {
		this.csvMap = csvMap;
	}

	public KeyServiceFactory getKeyServiceFactory() {
		return keyServiceFactory;
	}

	public void setKeyServiceFactory(KeyServiceFactory keyServiceFactory) {
		this.keyServiceFactory = keyServiceFactory;
	} 

}
