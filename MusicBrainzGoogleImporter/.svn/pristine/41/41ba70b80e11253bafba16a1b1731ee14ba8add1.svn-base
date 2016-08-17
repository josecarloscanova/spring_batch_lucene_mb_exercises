package org.nanotek;

/**
 * A template builder interface, establishes the definition that given I(info)
 * the method shall build the T (that defines a template of a document or a finite vector based on the I object), 
 * which means that for all I that belongs to some domain, the same output of type T shall be produced. 
 * Differently from the Transformer (pattern) which defines a "generic class" performing the transformation, 
 * the TemplateBuilder is generally designed to be constructed at 1 by 1 origin target classes.  
 * 
 * 
 * @author josecanova
 *
 * @param <T> the final result  or Template created based on the I (info) object.
 * @param <I>
 */

public interface TemplateBuilder<T, I> {

	public T createTemplate (I info);
	
}
