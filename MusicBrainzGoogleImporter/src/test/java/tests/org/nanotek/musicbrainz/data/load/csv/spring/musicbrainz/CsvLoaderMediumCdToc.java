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
import org.junit.Test;
import org.nanotek.batch.BlockExecutor;
import org.nanotek.beans.MediumCdToc;

import org.nanotek.opencsv.BaseCsvMapper;
import org.nanotek.opencsv.CsvBaseMapper;
import org.nanotek.opencsv.CsvTabReader;
import org.nanotek.opencsv.MapColumnStrategy;
import org.springframework.context.ApplicationContext;

public class CsvLoaderMediumCdToc extends CsvContextLoader{

	private static final Logger log = LoggerFactory.getLogger(CsvLoaderMediumCdToc.class);

	public CsvLoaderMediumCdToc() {
	}

	
	
	public static void main(String args[]) {
		new CsvLoaderMediumCdToc().initialize().run();
	}

	@Test
	@SuppressWarnings("resource")
	public void run()
	{ 
		try {
			CsvBaseMapper  csvMap = new CsvBaseMapper("MediumCdToc" , buildHashMap());
			File MediumFileBean = (File)csvContext.getBean("cdTocFile");
			FileReader csvFileReader = new FileReader (MediumFileBean);
			CsvTabReader csvTabReader = new CsvTabReader(csvFileReader);

			MapColumnStrategy <CsvBaseMapper, MediumCdToc> mapStrategy = new MapColumnStrategy<CsvBaseMapper, MediumCdToc> (csvMap);
			mapStrategy.setType(MediumCdToc.class);
			BaseCsvMapper<MediumCdToc> mapCsvMapper = new BaseCsvMapper<MediumCdToc>();
			String [] nextLine; 
			int lineCount = 0;
			//		XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream(new JettisonMappedXmlDriver())); 
			final List<MediumCdToc> mediumList =  new ArrayList<MediumCdToc>();
			while ((nextLine = csvTabReader.readNext()) != null) {
				//mapStrategy.buildMapping(nextLine.length);//it is not usind the length
//				MediumCdToc baseMap = mapCsvMapper.processLine(mapStrategy, nextLine);
				//			
				final MediumCdToc base = mapCsvMapper.processLine(mapStrategy, nextLine);
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
			log.debug(e.toString());
		}
	}


	public static Map<String,Integer> buildHashMap()
	{ 
		Map<String,Integer> csvMap = new HashMap<String,Integer>();

		csvMap.put("mediumCdTocId",0);
		csvMap.put("medium", 1);
		csvMap.put("cdToc", 2);

		return csvMap;
	}

}
