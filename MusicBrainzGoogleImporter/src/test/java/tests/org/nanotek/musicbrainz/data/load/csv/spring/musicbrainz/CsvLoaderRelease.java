package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.nanotek.batch.BlockExecutor;
import org.nanotek.beans.Release;
import org.nanotek.dao.DAO;
import org.nanotek.opencsv.BaseCsvMapper;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;

public class CsvLoaderRelease extends CsvContextLoader{

	private static final Logger log = Logger.getLogger(CsvLoaderRelease.class);

	public CsvLoaderRelease() {
	}

	
	
	public static void main(String args[]) {
		new CsvLoaderRelease().initialize().run();
	}

	@Test
	@SuppressWarnings("resource")
	public void run()
	{ 
		try {
			
			CsvBaseMapper  csvMap = new CsvBaseMapper("Release" , buildHashMap());
			File csvFile = (File)csvContext.getBean("releaseFile");
			FileReader csvFileReader = new FileReader (csvFile);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);

			MapColumnStrategy <CsvBaseMapper, Release> mapStrategy = new MapColumnStrategy<CsvBaseMapper, Release> (csvMap);
			mapStrategy.setType(Release.class);
			BaseCsvMapper<Release> mapCsvMapper = new BaseCsvMapper<Release>();
			String [] nextLine; 
			int lineCount = 0;
			//		XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			final List<Release> mediumList =  new ArrayList<Release>();
			while ((nextLine = csvTabReader.readNext()) != null) {
				final Release base = mapCsvMapper.processLine(mapStrategy, nextLine);
				lineCount++;
				mediumList.add(base);
			}
			executeDataInsert(mediumList, dataBaseContext);
			log.info("Line Count " + lineCount );
		} catch (IOException e) {
			e.printStackTrace();
			log.debug(e);
		}
	}

	public static Map<String,Integer> buildHashMap()
	{ 
		
//		columns[0] = "id";
//		columns[1] = "gid";
//		columns[2] = "name";
//		columns[3] = "artistCredit";
//		columns[4] = "releaseGroup";
//		columns[5] = "barCode";
//		columns[6] = "dateYear";
//		columns[7] = "dateMonth";
//		columns[8] = "dateDay";
//		columns[9] = "country";
//		columns[10] = "status";
//		columns[11] = "packaging";
//		columns[12] = "language";
//		columns[13] = "script";
		
		
//		private Long id;
//		private Long cdtocId;
//		private String discId; 
//		private String freedbId; 
//		private Long trackCount;
		
		Map<String,Integer> csvMap = new HashMap<String,Integer>();

		csvMap.put("releaseId",0);
		csvMap.put("gid", 1);
		csvMap.put("name", 2);
		csvMap.put("artistCredit", 3);
		csvMap.put("releaseGroup", 4);
//		csvMap.put("barCode", 5);
//		csvMap.put("artistCredit", 3);
		csvMap.put("country", 7);
//		csvMap.put("artistCredit", 3);
//		csvMap.put("artistCredit", 3);
		
		return csvMap;
	}

}
