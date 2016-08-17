package tests;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nanotek.beans.LabelAlias;
import org.nanotek.beans.mapping.LabelAliasMapping;
import org.nanotek.dao.BaseDAO;
import org.nanotek.dao.LabelAliasDAO;
import org.nanotek.indexer.util.key.KeyServiceFactoryException;
import org.nanotek.util.HibernateUtil;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class LabelAliasImporter {

	private static final String ADDRESS_FILE="F:\\musicbrainz\\mbdump.tar\\mbdump\\mbdump\\label_alias";


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
			LabelAliasMapping mapping = new LabelAliasMapping(); 
			BaseDAO<LabelAlias> dao = new LabelAliasDAO();
			dao.setHibernateSession(session);
			char separator = '\t';
			CSVReader reader = new CSVReader(new FileReader(ADDRESS_FILE), separator);
			int i = 0;
			String [] nextLine;
			trans = session.beginTransaction();
			while ((nextLine = reader.readNext()) != null) {
				CsvToBean<LabelAlias> map  = new CsvToBean<>();
				mapping.setType(LabelAlias.class);
				System.out.println("Array Lenght " + nextLine.length);
				LabelAlias labelAlias;
				labelAlias = map.processLine(mapping, nextLine);
				dao.persist(labelAlias);
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
