package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;
import org.nanotek.batch.BlockExecutor;
import org.nanotek.beans.Recording;
import org.nanotek.dao.DAO;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CsvLoaderRecording implements Insertable{


	private static final Logger log = Logger.getLogger(CsvLoaderRecording.class);

	public CsvLoaderRecording() {

	}

	public static void main (String[] args)
	{ 
		new CsvLoaderRecording().start();
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

			CsvBaseMapper  csvMap = new CsvBaseMapper("TableName" , buildHashMap());
			File recordingFileBean = (File)csvContext.getBean("recordingFile");
			FileReader csvFileReader = new FileReader (recordingFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);

			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 

			//			XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			List<Recording> recordingList =  new ArrayList<Recording>();
			int counter = 0;
			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);//it is not usind the length
				BaseMap baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
				//				
				final Recording base = new Recording();
				for (String key : baseMap.keySet()){ 
					try { 
						BeanUtilsBean.getInstance().setProperty(base , key, baseMap.get(key));
					}catch (Exception ex) 
					{ 
						throw new RuntimeException(ex);
					}
				}
				if (base.getName().length() <= 2500){ 
					recordingList.add(base);
					counter++;
				} 
				if (counter >= 40000)
				{ 
					executeDataInsert(recordingList, dataBaseContext);
					recordingList = new ArrayList<Recording>();
					counter = 0;
					log.info("Processed more 40000 " + new Date());
				}
			}
			if (counter !=0)
				executeDataInsert(recordingList, dataBaseContext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Map<String,Integer> buildHashMap()
	{ 
		Map<String,Integer> csvMap = new HashMap<String,Integer>();

		//		private Long recordingId; 
		//		private String gid; 
		//		private String name; 
		//		private Long artistCredit;
		//		private Long length;
		//		
		//		private Long id;
		//		private Long artistCreditId;
		//		private String name; 
		//		private Long artistCount; 
		//		private Long refCount;

		csvMap.put("recordingId",0);
		csvMap.put("gid", 1);
		csvMap.put("name", 2);
		csvMap.put("artistCredit", 3);
		csvMap.put("length", 4);
		return csvMap;
	}

}
