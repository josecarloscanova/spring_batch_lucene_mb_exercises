package org.nanotek.xstream;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import javax.annotation.PostConstruct;

import org.nanotek.Base;

import com.thoughtworks.xstream.XStream;

public class XStreamBaseSerializer<T extends Base<?>> implements PostConstructor<XStreamBaseSerializer>{

	private Class<? extends Base<?>> baseClass; 
	private  XStream xstream;
	
	
	public XStreamBaseSerializer(Class<T> baseClass, XStream xStream) {
		this.baseClass = baseClass;
		this.xstream = xStream;
	}

	@PostConstruct
	public void postConstruct() 
	{ 
		setClassBaseAlias(this.baseClass , this.xstream);
	}
	
	public Class<? extends Base<?>> getBaseClass() {
		return baseClass;
	}

	public void setBaseClass(Class<? extends Base<?>> baseClass) {
		this.baseClass = baseClass;
	}
	
	public XStream getXstream() {
		return xstream;
	}

	public void setXstream(XStream xstream) {
		this.xstream = xstream;
	}
	
	/**
	 * Xtream Base Delegation methods. 
	 */

	public void alias(String name, Class<?> type, Class<?> defaultImplementation) {
		xstream.alias(name, type, defaultImplementation);
	}

	public void alias(String name, Class<?> type) {
		xstream.alias(name, type);
	}

	public Object fromXML(InputStream xml, Object root) {
		return xstream.fromXML(xml, root);
	}

	public Object fromXML(InputStream input) {
		return xstream.fromXML(input);
	}

	public Object fromXML(Reader xml, Object root) {
		return xstream.fromXML(xml, root);
	}

	public Object fromXML(Reader xml) {
		return xstream.fromXML(xml);
	}

	public Object fromXML(String xml, Object root) {
		return xstream.fromXML(xml, root);
	}

	public Object fromXML(String xml) {
		return xstream.fromXML(xml);
	}

	public void setMode(int mode) {
		xstream.setMode(mode);
	}

	public void toXML(Object obj, OutputStream out) {
		xstream.toXML(obj, out);
	}

	public void toXML(Object obj, Writer out) {
		xstream.toXML(obj, out);
	}

	public String toXML(Object obj) {
		return xstream.toXML(obj);
	}
	
	private void setClassBaseAlias(Class<? extends Base<?>> baseClass2,
			XStream xstream2) {
		if (baseClass !=null && xstream !=null) 
		{ 
			alias(baseClass.getSimpleName() , baseClass);
		}
	}
}
