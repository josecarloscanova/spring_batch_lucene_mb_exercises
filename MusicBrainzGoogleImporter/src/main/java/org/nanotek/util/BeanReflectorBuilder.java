package org.nanotek.util;


/**
 * Interface that implements a "contruction" by reference using reflection.
 * Instead to dive into refective methods directly this interface determines
 * the contract that "builder class shall implement", emphatizing by its name
 * specification that is "desirable" the usage of reflection methods.
 *
 * @author josecanovamauger
 *
 * @param <R>
 * @param <K>
 */

public interface BeanReflectorBuilder <R , K>  {

	public K createBeanInstance(R ref);

}
