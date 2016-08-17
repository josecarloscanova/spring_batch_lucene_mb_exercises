package org.nanotek.opencsv;

import org.nanotek.Base;

/**
 * Used for fixed length CSV lines.
 * 
 */
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class    MapColumnStrategy<T extends CsvBaseMapper, I extends Base<?>> 
extends     ColumnPositionMappingStrategy<I>  
implements PostConstructorStrategy<T> {


	private T csvMapper; 
	
	public MapColumnStrategy(T csvMapper) {
		super();
		this.csvMapper = csvMapper;
	}

	/**
	 * Can use the buildMapping in case of intend to use the classical processline method instead of BeanUtilBean.
	 */
	@Override
	@Deprecated
	public void buildMapping() {
		assert (csvMapper !=null && csvMapper.size() >=1);
		String [] csvColumns = new String[csvMapper.getTargetSize()];
		try {
			for (Object key : csvMapper.keySet()){ 
				Integer position = csvMapper.get(key);
				if (position !=null)
					csvColumns[position] = key.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MappingStrategyException (e);
		}
		this.setColumnMapping(csvColumns);
	}

	@Deprecated
	public void buildMapping (Integer size) 
	{ 
		if (this.getColumnMapping() == null || this.getColumnMapping().length==0 ) { 
			assert (csvMapper !=null && csvMapper.size() >=1);
			String [] csvColumns = new String[size];
			try {
				for (Object key : csvMapper.keySet()){ 
					Integer position = csvMapper.get(key);
					if (position !=null)
						csvColumns[position] = key.toString();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new MappingStrategyException (e);
			}
			this.setColumnMapping(csvColumns);
		}
	}
	
	public T getCsvMapper() {
		return csvMapper;
	}

	public void setCsvMapper(T csvMapper) {
		this.csvMapper = csvMapper;
	}
}
