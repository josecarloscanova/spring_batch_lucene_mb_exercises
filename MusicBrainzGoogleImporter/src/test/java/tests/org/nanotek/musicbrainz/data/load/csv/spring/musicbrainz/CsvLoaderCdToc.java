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
import org.nanotek.beans.CdToc;
import org.nanotek.dao.DAO;
import org.nanotek.opencsv.BaseCsvMapper;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;

public class CsvLoaderCdToc extends CsvContextLoader{

	private static final Logger log = Logger.getLogger(CsvLoaderCdToc.class);

	public CsvLoaderCdToc() {
	}

	
	
	public static void main(String args[]) {
		new CsvLoaderCdToc().initialize().run();
	}

	@Test
	@SuppressWarnings("resource")
	public void run()
	{ 
		try {
			CsvBaseMapper  csvMap = new CsvBaseMapper("CdToc" , buildHashMap());
			File MediumFileBean = (File)csvContext.getBean("cdTocFile");
			FileReader csvFileReader = new FileReader (MediumFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);

			MapColumnStrategy <CsvBaseMapper, CdToc> mapStrategy = new MapColumnStrategy<CsvBaseMapper, CdToc> (csvMap);
			mapStrategy.setType(CdToc.class);
			BaseCsvMapper<CdToc> mapCsvMapper = new BaseCsvMapper<CdToc>();
			String [] nextLine; 
			int lineCount = 0;
			//		XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			final List<CdToc> mediumList =  new ArrayList<CdToc>();
			while ((nextLine = csvTabReader.readNext()) != null) {
				//mapStrategy.buildMapping(nextLine.length);//it is not usind the length
//				CdToc baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
				//			
				final CdToc base = mapCsvMapper.processLine(mapStrategy, nextLine);
//				for (String key : baseMap.keySet()){ 
//					try { 
//						BeanUtilsBean.getInstance().setProperty(base , key, baseMap.get(key));
//					}catch (Exception ex) 
//					{ 
//						throw new RuntimeException(ex);
//					}
//				}
				lineCount++;
				mediumList.add(base);
//				log.info(base);
			}
			log.info("Line Count " + lineCount );
					executeDataInsert(mediumList, dataBaseContext);
		} catch (IOException e) {
			e.printStackTrace();
			log.debug(e);
		}
	}

	public static Map<String,Integer> buildHashMap()
	{ 
		
//		columns[0] = "id";
//		columns[1] = "discId";
//		columns[2] = "freedbId";
//		columns[3] = "trackCount";
//		columns[4] = "leadOutOffSet";
//		columns[5] = "trackOffSet";
//		columns[6] = "degraded";
//		columns[7] = "created";
		
		
//		private Long id;
//		private Long cdtocId;
//		private String discId; 
//		private String freedbId; 
//		private Long trackCount;
		
		Map<String,Integer> csvMap = new HashMap<String,Integer>();

		csvMap.put("cdtocId",0);
		csvMap.put("discId", 1);
		csvMap.put("freedbId", 2);
		csvMap.put("trackCount", 3);
		
		return csvMap;
	}

}
