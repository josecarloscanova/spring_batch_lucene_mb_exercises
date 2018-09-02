package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.nanotek.batch.BlockExecutor;
import org.nanotek.beans.Recording;
import org.nanotek.beans.Track;

import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CsvLoaderTrack implements Insertable{


	private static final Logger log = LoggerFactory.getLogger(CsvLoaderTrack.class);

	public CsvLoaderTrack() {

	}

	public static void main (String[] args)
	{ 
		new CsvLoaderTrack().start();
	}
	
//	@Test
	@SuppressWarnings("resource")
	public void start () {

		try {

			String [] csvContextLocation = new String[] {
			"/file-loaders/mbz_files_context.xml"};
			ClassPathXmlApplicationContext csvContext = new ClassPathXmlApplicationContext(csvContextLocation);

			String [] dataBaseContextLocation = new String[] {
			"/database-loaders/spring-dao-context.xml"};
			ClassPathXmlApplicationContext dataBaseContext = new ClassPathXmlApplicationContext(dataBaseContextLocation);

			CsvBaseMapper  csvMap = new CsvBaseMapper("TRACK" , buildHashMap());
			File recordingFileBean = (File)csvContext.getBean("trackFile");
			FileReader csvFileReader = new FileReader (recordingFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);

			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 

			//			XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			List<Track> trackList =  new ArrayList<Track>();
			int counter = 0;
			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);//it is not usind the length
				BaseMap baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
				//				
				final Track base = new Track();
				for (String key : baseMap.keySet()){ 
					try { 
						BeanUtilsBean.getInstance().setProperty(base , key, baseMap.get(key));
					}catch (Exception ex) 
					{ 
						throw new RuntimeException(ex);
					}
				}
				if (base.getName().length() <= 1000){ 
//					log.info(base);
					trackList.add(base);
					counter++;
				} 
				if (counter >= 160000)
				{ 
					executeDataInsert(trackList, dataBaseContext);
					trackList = new ArrayList<Track>();
					counter = 0;
					log.info("Send to more 160000 " + new Date());
				}
			}
			if (counter !=0)
				executeDataInsert(trackList, dataBaseContext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public static Map<String,Integer> buildHashMap()
	{ 
		Map<String,Integer> csvMap = new HashMap<String,Integer>();

//		columns[0] = "id";
//		columns[1] = "recording";
//		columns[2] = "trackList";
//		columns[3] = "position";
//		columns[4] = "name";
//		columns[5] = "artistCredit";
//		columns[6] = "lenght";

		csvMap.put("trackId",0);
		csvMap.put("gid", 1);
		csvMap.put("recording", 2);
		csvMap.put("medium", 3);
		csvMap.put("position", 4);
		csvMap.put("number", 5);
		csvMap.put("name", 6);
		csvMap.put("artistCredit", 7);
		csvMap.put("length", 8);
		
		return csvMap;
	}

}
