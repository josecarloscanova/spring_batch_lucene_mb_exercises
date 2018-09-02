package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.Test;
import org.nanotek.batch.BlockExecutor;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.HashMapCsvMapper;
import org.nanotek.opencsv.MapColumnStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CsvLoaderArtistCredit {

	private static final Logger log = LoggerFactory.getLogger(CsvLoaderArtistCredit.class);
	
	public CsvLoaderArtistCredit() {
		
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
			File artistCreditFileBean = (File)csvContext.getBean("artistCreditFile");
			FileReader csvFileReader = new FileReader (artistCreditFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);
			
			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = new MapColumnStrategy<CsvBaseMapper, BaseMap> (csvMap);
			HashMapCsvMapper mapCsvMapper = new HashMapCsvMapper();
			String [] nextLine; 
			
//			XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			final List<ArtistCredit> artistCreditList =  Collections.synchronizedList(new ArrayList<ArtistCredit>());
			while ((nextLine = csvTabReader.readNext()) != null) {
				mapStrategy.buildMapping(nextLine.length);//it is not usind the length
				BaseMap baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
//				
				final ArtistCredit base = new ArtistCredit();
				for (String key : baseMap.keySet()){ 
					try { 
						BeanUtilsBean.getInstance().setProperty(base , key, baseMap.get(key));
					}catch (Exception ex) 
					{ 
						throw new RuntimeException(ex);
					}
				}
				artistCreditList.add(base);
			}
			executeDataInsert(artistCreditList, dataBaseContext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked"})
	public void executeDataInsert(final List<ArtistCredit> artistCreditNameList , ApplicationContext dataBaseContext)
	{ 
//		final DAO<ArtistCredit> dao = (DAO<ArtistCredit>) dataBaseContext.getBean("artistCreditNameDAO");
//		artistCreditNameList.parallelStream().forEach(new Consumer<ArtistCredit>() {
//			@Override
//			public void accept(ArtistCredit t) {
//				System.out.println("calling persist " + t.toString());
//				dao.persist(t);
//			}
//		});
		/*final BlockExecutor runnerExecutor = (BlockExecutor) dataBaseContext.getBean("blockExecutor");
		new Thread (
					new Runnable (){
						public void run(){
							runnerExecutor.execute(artistCreditNameList, dao);
						}
					}
				).run();*/
	}
	
	
	public static Map<String,Integer> buildHashMap()
	{ 
		Map<String,Integer> csvMap = new HashMap<String,Integer>();
		
//		columns[0] = "id";
//		columns[1] = "name";
//		columns[2] = "artistCount";
//		columns[3] = "refCount";
//		columns[4] = "created";
//		
//		private Long id;
//		private Long artistCreditId;
//		private String name; 
//		private Long artistCount; 
//		private Long refCount;
		
			csvMap.put("artistCreditId",0);
			csvMap.put("name", 1);
			csvMap.put("artistCount", 2);
			csvMap.put("refCount", 3);
		return csvMap;
	}
	
}
