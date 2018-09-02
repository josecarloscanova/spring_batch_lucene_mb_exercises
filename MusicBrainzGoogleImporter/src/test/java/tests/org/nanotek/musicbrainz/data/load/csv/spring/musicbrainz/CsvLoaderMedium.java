package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.Test;
import org.nanotek.batch.BlockExecutor;
import org.nanotek.beans.Medium;

import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;

public class CsvLoaderMedium extends CsvContextLoader{

	private static final Logger log = LoggerFactory.getLogger(CsvLoaderMedium.class);

	public CsvLoaderMedium() {
	}

	
	
	public static void main(String args[]) {
		new CsvLoaderMedium().initialize().run();
	}

	@Test
	@SuppressWarnings("resource")
	public void run()
	{ 
		try {
			CsvBaseMapper  csvMap = new CsvBaseMapper("Medium" , buildHashMap());
			File MediumFileBean = (File)csvContext.getBean("mediumFile");
			FileReader csvFileReader = new FileReader (MediumFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);

			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 
			int lineCount = 0;
			//		XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			final List<Medium> mediumList =  new ArrayList<Medium>();
			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);//it is not usind the length
				BaseMap baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
				//			
				final Medium base = new Medium();
				for (String key : baseMap.keySet()){ 
					try { 
						BeanUtilsBean.getInstance().setProperty(base , key, baseMap.get(key));
					}catch (Exception ex) 
					{ 
						throw new RuntimeException(ex);
					}
				}
				lineCount++;
				mediumList.add(base);
			}
			log.info("Line Count " + lineCount );
					executeDataInsert(mediumList, dataBaseContext);
		} catch (IOException e) {
			e.printStackTrace();
			log.debug(e.toString());
		}
	}

	public static Map<String,Integer> buildHashMap()
	{ 
		Map<String,Integer> csvMap = new HashMap<String,Integer>();

		//		columns[0] = "id";
		//		columns[2] = "trackList";
		//		columns[3] = "release";
		//		columns[4] = "position";
		//		columns[5] = "format";
		//		columns[6] = "name";

		csvMap.put("mediumId",0);
		csvMap.put("release", 1);
		csvMap.put("format", 2);
		csvMap.put("name", 3);
		csvMap.put("trackCount", 6);

		return csvMap;
	}

}
