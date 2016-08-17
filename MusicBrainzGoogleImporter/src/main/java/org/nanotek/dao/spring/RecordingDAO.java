package org.nanotek.dao.spring;


import org.nanotek.beans.Recording;

public interface RecordingDAO<T extends Recording> {

	public  T findById (Long id);
}
