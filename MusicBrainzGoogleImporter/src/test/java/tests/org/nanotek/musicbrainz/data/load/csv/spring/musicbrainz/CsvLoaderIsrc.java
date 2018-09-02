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
import org.nanotek.beans.Isrc;

import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CsvLoaderIsrc implements Insertable {

	private static final Logger log = LoggerFactory.getLogger(CsvLoaderIsrc.class);
	
	public CsvLoaderIsrc() {
		
	}

	@Test
	@SuppressWarnings("resource")
	public void main() {
		
		try {
			
			String [] csvContextLocation = new String[] {
			"/file-loaders/mbz_files_context.xml"};
			ClassPathXmlApplicationContext csvContext = new ClassPathXmlApplicationContext(csvContextLocation);
			
			String [] dataBaseContextLocation = new String[] {
			"/database-loaders/spring-dao-context.xml"};
			ClassPathXmlApplicationContext dataBaseContext = new ClassPathXmlApplicationContext(dataBaseContextLocation);
			CsvBaseMapper  csvMap = new CsvBaseMapper("TableName" , buildHashMap());
			File isrcFileBean = (File)csvContext.getBean("isrcFile");
			FileReader csvFileReader = new FileReader (isrcFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);
			
			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 
			
//			XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			final List<Isrc> isrcList =  new ArrayList<Isrc>();
			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);//it is not usind the length
				BaseMap baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
//				
				final Isrc base = new Isrc();
				for (String key : baseMap.keySet()){ 
					try { 
						BeanUtilsBean.getInstance().setProperty(base , key, baseMap.get(key));
					}catch (Exception ex) 
					{ 
						throw new RuntimeException(ex);
					}
				}
				log.info(base.toString());
				isrcList.add(base);
			}
			executeDataInsert(isrcList, dataBaseContext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public static Map<String,Integer> buildHashMap()
	{ 
		Map<String,Integer> csvMap = new HashMap<String,Integer>();
		
		
//		columns[0] = "id";
//		columns[1] = "recording";
//		columns[2] = "source";
//		columns[3] = "isrc";
		
			csvMap.put("isrcId",0);
			csvMap.put("recording", 1);
			csvMap.put("isrc", 2);
		return csvMap;
	}
	
}
