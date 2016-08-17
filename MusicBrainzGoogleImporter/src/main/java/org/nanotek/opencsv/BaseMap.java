package org.nanotek.opencsv;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class BaseMap implements Map<String,String>,Base<String>{

	@Override
	public String toString() {
		return "BaseMap [id=" + id + ", innerMap=" + innerMap + "]";
	}
	private String id; 
	
	private Map<String,String> innerMap = new HashMap<String,String>();
	
	public BaseMap(String id)
	{
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public int size() {
		return innerMap.size();
	}
	public boolean isEmpty() {
		return innerMap.isEmpty();
	}
	public boolean containsKey(Object key) {
		return innerMap.containsKey(key);
	}
	public boolean containsValue(Object value) {
		return innerMap.containsValue(value);
	}
	public String get(Object key) {
		return innerMap.get(key);
	}
	public String put(String key, String value) {
		return innerMap.put(key, value);
	}
	public String remove(Object key) {
		return innerMap.remove(key);
	}
	public void putAll(Map<? extends String, ? extends String> m) {
		innerMap.putAll(m);
	}
	public void clear() {
		innerMap.clear();
	}
	public Set<String> keySet() {
		return innerMap.keySet();
	}
	public Collection<String> values() {
		return innerMap.values();
	}
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		return innerMap.entrySet();
	}
	public boolean equals(Object o) {
		return innerMap.equals(o);
	}
	public int hashCode() {
		return innerMap.hashCode();
	}
}
