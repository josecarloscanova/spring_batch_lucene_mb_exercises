package test.org.nanotek.opencsv;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.nanotek.Base;
import org.nanotek.base.LongBase;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.nanotek.xstream.XStreamBaseSerializer;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class CsvLoaderBaseMapStrategyTest {

	protected CSVReader reader;
	protected ColumnPositionMappingStrategy<Base<?>> itemMapping;
	protected CsvToBean<Base<?>> csvMap;
	
	private static final Logger log = Logger.getLogger(CsvLoaderBaseMapStrategyTest.class);
	
	public CsvLoaderBaseMapStrategyTest() {
		
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			
			CsvBaseMapper  csvMap = new CsvBaseMapper("TableName" , buildHashMap());
			FileReader csvFileReader = new FileReader ("C:/Users/josecanova/Downloads/mbdump.tar/mbdump/mbdump/artist");
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);
			
			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 
			
			XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 

			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);
				BaseMap base = mapCsvMapper.processLine(mapStrategy, nextLine);
//				log.debug(base.toString());
				log.debug(baseSerializer.toXML(base));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Map<String,Integer> buildHashMap()
	{ 
		Map<String,Integer> csvMap = new HashMap<String,Integer>();
			
			csvMap.put("id", 0);
			csvMap.put("gid", 1);
			csvMap.put("name", 2);
			csvMap.put("sortName", 3);
			csvMap.put("type", 11);
			csvMap.put("gender", 12);
			csvMap.put("area", 13);
	
		return csvMap;
	}
	
}
