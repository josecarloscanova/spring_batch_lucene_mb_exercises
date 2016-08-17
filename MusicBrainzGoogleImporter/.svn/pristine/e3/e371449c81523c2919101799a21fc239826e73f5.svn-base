package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.mapping.ArtistCreditNameMapping;
import org.nanotek.dao.ArtistCreditNameDAO;
import org.nanotek.dao.BaseDAO;
import org.nanotek.indexer.util.key.KeyServiceFactory;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class ArtistCreditNameImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\artist_credit_name";


	/**
	 * @param args
	 * @throws IOException 
	 * @throws KeyServiceFactoryException 
	 */
	public static void main(String[] args) {
		try {
			HibernateUtil util = new HibernateUtil();
			Session session = util.getSessionFactory().openSession();
			ArtistCreditNameMapping mapping = new ArtistCreditNameMapping(); 
			BaseDAO<ArtistCreditName> dao = new ArtistCreditNameDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			Transaction trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<ArtistCreditName> map  = new CsvToBean<>();
				mapping.setType(ArtistCreditName.class);
				System.out.println("Array Lenght " + nextLine.length);
				ArtistCreditName artistCreditName;
				artistCreditName = map.processLine(mapping, nextLine);
				UUID propID = (UUID) (KeyServiceFactory.newInstance()).getKey(UUID.class);
				artistCreditName.setId(propID.toString());
				dao.persist(artistCreditName);
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
