package org.nanotek.dao.spring;

import org.nanotek.beans.ReleaseName;

public interface ReleaseNameDAO<T extends ReleaseName>  {

	public T findById (String id);
	
}
