package org.nanotek.apache.beans;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.LazyDynaClass;
import org.nanotek.util.BeanReflectorBuilder;

/**
 * An attempt to use reflection to build a generic base class mapping using Dynabean.
 * The objective is to use to map the CSV file onto a DynaBean constructed over a DynaClass that refers to the CSV Mapping class
 * to fix properly which properties where readen from the CSV file.
 * TODO:Finish it!
 * @author josecanovamauger
 *
 */
public class DynaBeanBuilder implements  BeanReflectorBuilder<Map<String,?>, DynaBean> {

	/**
	 * @param mapping the array constructed to map the CSV file.
	 */
	public DynaBeanBuilder(){
	}

	@Override
	public DynaBean createBeanInstance(Map<String,?> values) {

		LazyDynaBean lazyDynaBean = new LazyDynaBean (new LazyDynaClass("DynaBeanName"));
		//TODO: 
		for (String key : values.keySet()) 
		{ 
			lazyDynaBean.set(key,values.get(key));
		}
		
		return lazyDynaBean;
	}
	
	public static void main (String args[]) 
	{ 
		Map<String,Object> map = new HashMap<>();
		map.put("tes", "teste");
		map.put("teste" , new Integer(0));
		DynaBean dynaBean = new DynaBeanBuilder().createBeanInstance(map);
		System.out.println(dynaBean.get("tes") + "  " + dynaBean.get("teste"));
	}
}
