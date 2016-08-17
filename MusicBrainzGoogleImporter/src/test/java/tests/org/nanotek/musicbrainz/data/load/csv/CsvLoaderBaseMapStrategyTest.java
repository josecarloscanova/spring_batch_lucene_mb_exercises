package tests.org.nanotek.musicbrainz.data.load.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.nanotek.base.LongBase;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.nanotek.xstream.XStreamBaseSerializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class CsvLoaderBaseMapStrategyTest {

	private static final Logger log = Logger.getLogger(CsvLoaderBaseMapStrategyTest.class);
	
	public CsvLoaderBaseMapStrategyTest() {
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			
			CsvBaseMapper  csvMap = new CsvBaseMapper("TableName" , buildHashMap());
			FileReader csvFileReader = new FileReader ("C:\\java\\music_brainz\\mbdump\\artist");
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
