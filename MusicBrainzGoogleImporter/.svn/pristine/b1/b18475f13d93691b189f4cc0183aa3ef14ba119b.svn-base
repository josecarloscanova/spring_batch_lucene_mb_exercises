package org.nanotek.opencsv;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.nanotek.Base;

/**
 * TODO: Change the class to "create a equivalence validator" on Target Class - and the Map class. 
 * 
 * @author josecanovamauger.
 *
 * @param <T>
 */
//Avoiding the Usage of this. Type & AnnotatedElement & GenericDeclaration & Serializable & Base<?>
@SuppressWarnings("serial")
public class CsvBaseMapper implements Map<String, Integer> , Base<String>{

	//works fine with the "Bean Name";
	private String id;
	private Map<String,Integer> surrogateMap; 
	
	public CsvBaseMapper(String id,Map<String, Integer> surrogateMap ) {
		super();
		this.surrogateMap = surrogateMap;
	}

	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return surrogateMap.isEmpty();
	}
	@Override
	public boolean containsKey(Object key) {
		return surrogateMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return surrogateMap.containsValue(value);
	}

	@Override
	public Integer get(Object key) {
		return surrogateMap.get(key);
	}

	@Override
	public Integer put(String key, Integer value) {
		return surrogateMap.put(key, value);
	}

	@Override
	public Integer remove(Object key) {
		return surrogateMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Integer> m) {
		surrogateMap.putAll(m);
	}

	@Override
	public void clear() {
		surrogateMap.clear();
	}
	
	@Override
	public Set<String> keySet() {
		return surrogateMap.keySet();
	}

	@Override
	public Collection<Integer> values() {
		return surrogateMap.values();
	}

	@Override
	public Set<java.util.Map.Entry<String, Integer>> entrySet() {
		return surrogateMap.entrySet();
	}

	@Override
	public boolean equals(Object o) {
		return surrogateMap.equals(o);
	}

	@Override
	public int hashCode() {
		return surrogateMap.hashCode();
	}

	public Integer getTargetSize() {
		return (surrogateMap !=null)?surrogateMap.size():0;
	}

}
