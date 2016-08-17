package org.nanotek;

import java.util.Map;

/**
 * An Interface that defines that given a type some sort a flat map structure 
 * will be returned calling the method getMap, usually used to convert Pojo to Map<String, Propety<String>> 
 * 
 * @author josecanovamauger.
 *
 * @param <T> Base Type for "Coercion". Defined as Coercion not "Conversion" since the 
 * original type of the objects to be mapped is not obligatory the same on the "Mapped Object".
 * 
 */
public interface Mappable <T>{

	/**
	 * 
	 * @param type
	 * @return a Map that represents some sort of transformation over T. 
	 */
	public <S extends Map<String,?>> S getMap(T type);
	
}
