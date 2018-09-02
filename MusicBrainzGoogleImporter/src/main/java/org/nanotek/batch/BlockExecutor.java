package org.nanotek.batch;

import java.util.List;

import org.nanotek.Base;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BlockExecutor<T extends Base<?>> implements DAOExecutor<T>{//

	
	public BlockExecutor() {
	}

	@Override
	@Transactional (readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void execute(List<T> data) {
		for (T base : data)
		{ 
			Thread thread = new Thread(new PersintenceRunnable(base)); 
			thread.run();
		}
		
	}
	
	
	class PersintenceRunnable implements Runnable {

		private T base;

		PersintenceRunnable (T base )
		{ 
			this.base = base; 
		}
		
		@Override
		public void run() {
		} 
	}

	
}
