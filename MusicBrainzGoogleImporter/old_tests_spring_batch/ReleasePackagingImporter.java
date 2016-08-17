package tests;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.ReleasePackaging;
import org.nanotek.beans.mapping.ReleasePackageMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.ReleasePackagingDAO;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ReleasePackagingImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\release_packaging";


	/**
	 * @param args
	 * @throws IOException 
	 * @throws KeyServiceFactoryException 
	 */
	public static void main(String[] args) {
		try {
			HibernateUtil util = new HibernateUtil();
			Session session = util.getSessionFactory().openSession();
			ReleasePackageMapping mapping = new ReleasePackageMapping(); 
			BaseDAO<ReleasePackaging> dao = new ReleasePackagingDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			Transaction trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<ReleasePackaging> map  = new CsvToBean<>();
				mapping.setType(ReleasePackaging.class);
				System.out.println("Array Lenght " + nextLine.length);
				ReleasePackaging release;
				release = map.processLine(mapping, nextLine);
//				UUID propID = (UUID) (KeyServiceFactory.newInstance()).getKey(UUID.class);
//				artistKey.setId(propID.toString());
				dao.persist(release);
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
		}
	}
}
