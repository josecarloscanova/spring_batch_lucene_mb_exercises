package tests.org.nanotek.dao.spring;

import java.util.List;

import org.junit.Test;
import org.nanotek.beans.ArtistName;
import org.nanotek.dao.DAO;
import org.nanotek.dao.spring.ArtistNameDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoArtistName {

	public DaoArtistName() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test()
	{ 
		String [] baseContext = new String[] {
		"/database-loaders/spring-dao-context.xml"};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(baseContext);
		ArtistNameDAO<ArtistName> dao = (ArtistNameDAO<ArtistName>) ctx.getBean("artistNameDAO");
		List<?> result = dao.findByName("%Roxanne Emery%");
		System.out.println(result.size());
	}

}
