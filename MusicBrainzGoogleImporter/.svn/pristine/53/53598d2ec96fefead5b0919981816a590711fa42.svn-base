package tests;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.Label;
import org.nanotek.beans.mapping.LabelMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.LabelDAO;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class LabelImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\label";


	/**
	 * @param args
	 * @throws IOException 
	 * @throws KeyServiceFactoryException 
	 */
	public static void main(String[] args) {
		try {
			HibernateUtil util = new HibernateUtil();
			Session session = util.getSessionFactory().openSession();
			LabelMapping mapping = new LabelMapping(); 
			BaseDAO<Label> dao = new LabelDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			Transaction trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<Label> map  = new CsvToBean<>();
				mapping.setType(Label.class);
				System.out.println("Array Lenght " + nextLine.length);
				Label label;
				label = map.processLine(mapping, nextLine);
				dao.persist(label);
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
