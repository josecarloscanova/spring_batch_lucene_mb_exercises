package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class CsvContextLoader implements Insertable{

	protected ClassPathXmlApplicationContext csvContext;
	protected ClassPathXmlApplicationContext dataBaseContext;

	@Before
	public CsvContextLoader initialize() {
		String [] csvContextLocation = new String[] {
				"/file-loaders/mbz_files_context.xml"};
		csvContext = new ClassPathXmlApplicationContext(csvContextLocation);

		String [] dataBaseContextLocation = new String[] {
		"/database-loaders/spring-dao-context.xml"};
		dataBaseContext = new ClassPathXmlApplicationContext(dataBaseContextLocation);
		return this;
	}

	public abstract void run();
}
