package org.nanotek.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private SessionFactory sessionFactory;

	private  SessionFactory buildSessionFactory() 
	{
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return sessionFactory = new Configuration()
            				.configure(new File("C:/Users/josecanova/workspace_luna/MusicBrainzGoogleImporter/src/main/java/org/nanotek/conf/hibernate.cfg.xml"))
            				.buildSessionFactory();
        }catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public  SessionFactory getSessionFactory() 
    {
    	if (sessionFactory !=null) 
    		return sessionFactory; 
    	else 
    		synchronized (this){ 
    	        return  buildSessionFactory();
    		}
    		
    }

    public static void main (String args[]) 
    { 
    	HibernateUtil util = new HibernateUtil();
    	util.getSessionFactory();
    }
    
}