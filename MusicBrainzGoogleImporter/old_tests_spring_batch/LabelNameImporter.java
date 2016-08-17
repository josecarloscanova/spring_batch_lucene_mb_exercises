package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.LabelName;
import org.nanotek.beans.mapping.LabelNameMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.LabelNameDAO;
import org.nanotek.indexer.util.key.KeyServiceFactory;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class LabelNameImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\label_name";


	/**
	 * @param args
	 * @throws IOException 
	 * @throws KeyServiceFactoryException 
	 */
	public static void main(String[] args) {
		try {
			HibernateUtil util = new HibernateUtil();
			Session session = util.getSessionFactory().openSession();
			LabelNameMapping mapping = new LabelNameMapping(); 
			BaseDAO<LabelName> dao = new LabelNameDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			Transaction trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<LabelName> map  = new CsvToBean<>();
				mapping.setType(LabelName.class);
				System.out.println("Array Lenght " + nextLine.length);
				LabelName LabelName;
				LabelName = map.processLine(mapping, nextLine);
				UUID propID = (UUID) (KeyServiceFactory.newInstance()).getKey(UUID.class);
				LabelName.setId(propID.toString());
				dao.persist(LabelName);
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
			if (trans.isActive()) 
				trans.commit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
