package org.nanotek;

import java.util.Map;

/**
 * Extends the Mappable Interface since defines a Reference Type 
 * to extract the flat map from a base class.
 * 
 * @author josecanovamauger.
 *
 * @param <T>
 * @param <R>
 */
public interface MappableReference <T , R> extends Mappable<T>{

	@Override
	public <S extends Map<String, ?>> S getMap(T type);
	
	public <S extends Map<String, ?>> S getMap(T type,R reference);
	
}
