package tests.org.nanotek.musicbrainz.data.load;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MixedContextConfigTest {
	
	@Test
	public void test() {
		String [] baseContext = new String[] {
				"/mixed-context-loaders/context-config.xml"};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(baseContext);
	}
}

