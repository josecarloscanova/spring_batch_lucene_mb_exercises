package org.nanotek.dao.spring;

import org.nanotek.beans.WorkName;

public interface WorkNameDAO<T extends WorkName> {

	public T findById (String id);
}
