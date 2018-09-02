package org.nanotek.batch;

import java.util.List;

import org.nanotek.Base;


public interface DAOExecutor<T extends Base<?>> {

	
	public void execute (List<T> data);
	
}
