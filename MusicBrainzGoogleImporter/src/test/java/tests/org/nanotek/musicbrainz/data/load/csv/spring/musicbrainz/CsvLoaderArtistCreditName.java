package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.nanotek.Base;
import org.nanotek.batch.BlockExecutor;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.dao.DAO;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CsvLoaderArtistCreditName implements Insertable{

	
	private static final Logger log = Logger.getLogger(CsvLoaderArtistCreditName.class);
	
	public CsvLoaderArtistCreditName() {
		
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
			@SuppressWarnings("unchecked")
			CsvBaseMapper  csvMap = new CsvBaseMapper("TableName" , buildHashMap());
			File artistFileBean = (File)csvContext.getBean("artistCreditNameFile");
			FileReader csvFileReader = new FileReader (artistFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);
			
			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 
			
//			XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			final List<ArtistCreditName> artistCreditNameList =  new ArrayList<ArtistCreditName>();
			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);
				BaseMap baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
//				
				final ArtistCreditName base = new ArtistCreditName();
				for (String key : baseMap.keySet()){ 
					try { 
						BeanUtilsBean.getInstance().setProperty(base , key, baseMap.get(key));
					}catch (Exception ex) 
					{ 
						throw new RuntimeException(ex);
					}
				}
					artistCreditNameList.add(base);
			}
			
			executeDataInsert(artistCreditNameList , dataBaseContext);
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
			csvMap.put("artistCredit",0);
			csvMap.put("position", 1);
			csvMap.put("artist", 2);
			csvMap.put("name", 3);
			csvMap.put("joinPhrase", 4);
		return csvMap;
	}
	
}
