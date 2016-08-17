package tests;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.MediumFormat;
import org.nanotek.beans.mapping.MediumFormatMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.MediumFormatDAO;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class MediumFormatImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\medium_format";


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
			MediumFormatMapping mapping = new MediumFormatMapping(); 
			BaseDAO<MediumFormat> dao = new MediumFormatDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<MediumFormat> map  = new CsvToBean<>();
				mapping.setType(MediumFormat.class);
				System.out.println("Array Lenght " + nextLine.length);
				MediumFormat mediumFormat;
				mediumFormat = map.processLine(mapping, nextLine);
//				UUID propID = (UUID) (KeyServiceFactory.newInstance()).getKey(UUID.class);
//				artistKey.setId(propID.toString());
				dao.persist(mediumFormat);
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
			if (trans !=null && trans.isActive()){ 
				trans.commit();
			}
		}
	}
}
