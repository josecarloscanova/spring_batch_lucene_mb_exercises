package test.org.nanotek.xstream;

import org.nanotek.base.LongBase;
import org.nanotek.beans.ArtistName;
import org.nanotek.xstream.XStreamBaseSerializer;

import com.thoughtworks.xstream.XStream;

public class XStreamBaseSerializerTest {

	public XStreamBaseSerializerTest() {
	}

	public static void main(String[] args)
	{ 
		XStreamBaseSerializer baseSerializer = new XStreamBaseSerializer(LongBase.class, new XStream()); 
		System.out.println(baseSerializer.toXML(new ArtistName()));
	}
}
