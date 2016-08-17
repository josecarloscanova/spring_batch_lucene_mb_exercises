package org.nanotek.dao.spring;

import org.nanotek.beans.Label;

public interface LabelDAO<T extends Label> {

	public T findById (Long id);
	
}
