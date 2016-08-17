package tests;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.WorkAlias;
import org.nanotek.beans.mapping.WorkAliasMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.WorkAliasDAO;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class WorkAliasImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\work_alias";


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
			WorkAliasMapping mapping = new WorkAliasMapping(); 
			BaseDAO<WorkAlias> dao = new WorkAliasDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<WorkAlias> map  = new CsvToBean<>();
				mapping.setType(WorkAlias.class);
				System.out.println("Array Lenght " + nextLine.length);
				WorkAlias workAlias;
				workAlias = map.processLine(mapping, nextLine);
//				UUID propID = (UUID) (KeyServiceFactory.newInstance()).getKey(UUID.class);
//				artistKey.setId(propID.toString());
				dao.persist(workAlias);
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
			{ 
				trans.commit();
			}
		}
	}
}
