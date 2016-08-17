package tests;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.WorkType;
import org.nanotek.beans.mapping.WorkTypeMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.WorkTypeDAO;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class WorkTypeImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\work_type";


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
			WorkTypeMapping mapping = new WorkTypeMapping(); 
			BaseDAO<WorkType> dao = new WorkTypeDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<WorkType> map  = new CsvToBean<>();
				mapping.setType(WorkType.class);
				System.out.println("Array Lenght " + nextLine.length);
				WorkType work;
				work = map.processLine(mapping, nextLine);
//				UUID propID = (UUID) (KeyServiceFactory.newInstance()).getKey(UUID.class);
//				artistKey.setId(propID.toString());
				dao.persist(work);
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
