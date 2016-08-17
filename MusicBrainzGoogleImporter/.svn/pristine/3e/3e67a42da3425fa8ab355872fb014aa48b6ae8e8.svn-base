package org.nanotek.opencsv;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.nanotek.Base;

import au.com.bytecode.opencsv.bean.CsvToBean;

public class BaseCsvMapper< T extends Base<?>>  extends CsvToBean<MapColumnStrategy<CsvBaseMapper, T> , T>{

	public BaseCsvMapper() {
		// TODO Auto-generated constructor stub
	}


		@Override
		public T processLine(MapColumnStrategy<CsvBaseMapper, T> mapper, String[] line) throws StrategyException{
			T bean = null;
			try { 
				bean = mapper.createBean();
//				bean = new BaseMap("");
//				MapColumnStrategy <CsvBaseMapper, BaseMap> mapStrategy = mapper;
				CsvBaseMapper csvBaseMapper = mapper.getCsvMapper(); 
				for (String key : csvBaseMapper.keySet()){ 
					BeanUtilsBean.getInstance().setProperty(bean , key,  (line[csvBaseMapper.get(key)] !=null)? line[csvBaseMapper.get(key)].trim():"");
//					bean.put(key, (line[csvBaseMapper.get(key)] !=null)? line[csvBaseMapper.get(key)].trim():"");
				}
			} catch (Exception e) 
			{ 
				throw new StrategyException (e);
			}
			return bean;
		}
		
}
