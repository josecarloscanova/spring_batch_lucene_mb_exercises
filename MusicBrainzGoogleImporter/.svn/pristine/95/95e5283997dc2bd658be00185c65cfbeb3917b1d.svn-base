package tests.org.nanotek.musicbrainz.data.load.csv.spring;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.nanotek.beans.ArtistName;
import org.nanotek.dao.DAO;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CsvLoaderDataBaseMapStrategyTest {

	
	private static final Logger log = Logger.getLogger(CsvLoaderDataBaseMapStrategyTest.class);
	
	public CsvLoaderDataBaseMapStrategyTest() {
		
	}

	@Test
	@SuppressWarnings("resource")
	public  void main() {
		
		try {
			
			String [] csvContextLocation = new String[] {
			"/file-loaders/mbz_files_context.xml"};
			ClassPathXmlApplicationContext csvContext = new ClassPathXmlApplicationContext(csvContextLocation);
			
			String [] dataBaseContextLocation = new String[] {
			"/database-loaders/spring-dao-context.xml"};
			ClassPathXmlApplicationContext dataBaseContext = new ClassPathXmlApplicationContext(dataBaseContextLocation);
			@SuppressWarnings("unchecked")
			DAO<ArtistName> dao = (DAO<ArtistName>) dataBaseContext.getBean("artistNameDAO");
			
			CsvBaseMapper  csvMap = new CsvBaseMapper("TableName" , buildHashMap());
			File artistFileBean = (File)csvContext.getBean("artistFile");
			FileReader csvFileReader = new FileReader (artistFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);
			
			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 
			
//			XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 

			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);
				BaseMap base = mapCsvMapper.processLine(mapStrategy, nextLine);
//				
				ArtistName artistName = new ArtistName(); 
				artistName.setName(base.get("name"));
				artistName.setSortName(base.get("sortName"));
				artistName.setMbid(new Long(base.get("id")));
				artistName.setGid("gid");
				artistName.setType((isNumber(base.get("type"))?formatNumber(base.get("type")):0));
				artistName.setGender((isNumber(base.get("gender"))?formatNumber(base.get("gender")):0));
				artistName.setGender((isNumber(base.get("area"))?formatNumber(base.get("area")):0));
				dao.persist(artistName);
//				log.debug(base.toString());
//				log.debug(baseSerializer.toXML(base));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isNumber(String string) {
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(string);
		return (string!=null)?matcher.find():false;
	}

	private Integer formatNumber(String string) {
		Integer num = 0; 
		try { 
			num = new Integer(string);
		}catch(Exception ex){}
		return num;
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
	
	public static void main (String [] args)
	{ 
		System.out.println(isNumber("\\N"));
		System.out.println (isNumber("232"));
		System.out.println (isNumber(""));
		System.out.println (isNumber("asd70asas"));
		System.out.println (isNumber("70asas"));
		System.out.println (isNumber("asas"));
		System.out.println (isNumber("asas70"));
	}
	
}
