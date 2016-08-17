package org.nanotek.opencsv;

import au.com.bytecode.opencsv.bean.CsvToBean;

public class HashMapCsvMapper extends CsvToBean<MapColumnStrategy<CsvBaseMapper, BaseMap> , BaseMap>{

	public HashMapCsvMapper() {
	}


	@Override
	public BaseMap processLine(MapColumnStrategy<CsvBaseMapper, BaseMap> mapper, String[] line) throws StrategyException{
		BaseMap bean = null;
		try { 
//			bean = mapper.createBean();
			bean = new BaseMap("");
//			MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = mapper;
			CsvBaseMapper csvBaseMapper = mapper.getCsvMapper(); 
			for (String key : csvBaseMapper.keySet()){ 
				bean.put(key, (line[csvBaseMapper.get(key)] !=null)? line[csvBaseMapper.get(key)].trim():"");
			}
		} catch (Exception e) 
		{ 
			throw new StrategyException (e);
		}
		return bean;
	}
}
