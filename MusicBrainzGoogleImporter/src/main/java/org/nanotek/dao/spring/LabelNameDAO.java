package org.nanotek.dao.spring;

import org.nanotek.beans.LabelName;

public interface LabelNameDAO<T extends LabelName> {

	public T findById (String id);
	
}
