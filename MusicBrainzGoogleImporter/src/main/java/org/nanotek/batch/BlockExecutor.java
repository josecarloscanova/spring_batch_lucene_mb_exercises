package org.nanotek.batch;

import java.util.List;

import org.nanotek.Base;
import org.nanotek.dao.DAO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BlockExecutor<T extends Base<?>> implements DAOExecutor<T>{

	
	public BlockExecutor() {
	}

	@Override
	@Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void execute(List<T> data, DAO<T> dao) {
		for (T base : data)
		{ 
			Thread thread = new Thread(new PersintenceRunnable(base, dao)); 
			thread.run();
		}
		
	}
	
	
	class PersintenceRunnable implements Runnable {

		private T base;
		private DAO<T> dao;

		PersintenceRunnable (T base , DAO<T> dao)
		{ 
			this.base = base; 
			this.dao = dao;
		}
		
		@Override
		public void run() {
			dao.persist(base);
		} 
	}

	
}
