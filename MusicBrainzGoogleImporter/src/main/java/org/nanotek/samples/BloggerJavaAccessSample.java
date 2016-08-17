package org.nanotek.samples;

import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class BloggerJavaAccessSample {

	public static void main(String[] args)
	{ 
		URL url;
		try {
			url = new URL("https://www.googleapis.com/blogger/v3/blogs/2045640289942179582/posts/995164709712956077?key=AIzaSyDh0Bmqa-9RQIpASA1tNATVsD_PZF3CJRQ");
			InputStream is = url.openStream();
			JsonReader rdr = Json.createReader(is);
			JsonObject result = rdr.readObject();
//			JsonArray results = obj.getJsonArray("data");
//			for (JsonObject result : results.getValuesAs(JsonObject.class)) {
				System.out.print(result.getJsonObject("author").getString("displayName"));
				System.out.print(": ");
				System.out.println(result.getString("message", ""));
				System.out.println("-----------");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
