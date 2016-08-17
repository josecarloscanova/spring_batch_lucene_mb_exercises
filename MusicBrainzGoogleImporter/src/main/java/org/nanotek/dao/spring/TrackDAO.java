package org.nanotek.dao.spring;

import org.nanotek.beans.Track;

public interface TrackDAO<T extends Track> {

	public T findById (String id);
}
