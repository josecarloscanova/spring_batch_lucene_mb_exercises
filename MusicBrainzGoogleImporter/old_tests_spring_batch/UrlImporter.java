package tests;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.Url;
import org.nanotek.beans.mapping.UrlMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.UrlDAO;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class UrlImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\url";

	/**
	 * @param args
	 * @throws IOException 
	 * @throws KeyServiceFactoryException 
	 */
	public static void main(String[] args) {
		
		Transaction trans = null; 
		
		try {
			HibernateUtil util = new HibernateUtil();
			Session session = util.getSessionFactory().openSession();
			UrlMapping mapping = new UrlMapping(); 
			BaseDAO<Url> dao = new UrlDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<Url> map  = new CsvToBean<>();
				mapping.setType(Url.class);
				System.out.println("Array Lenght " + nextLine.length);
				Url Url;
				Url = map.processLine(mapping, nextLine);
//				UUID propID = (UUID) (KeyServiceFactory.newInstance()).getKey(UUID.class);
//				artistKey.setId(propID.toString());
				dao.persist(Url);
				System.out.println("mapped");
				i++; 
				if (i > 10000) 
				{ 
					trans.commit();
					i = 0; 
					session.clear();
					trans = session.beginTransaction();
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}finally { 
			if (trans !=null && trans.isActive())
				trans.commit();
		}
	}
}
