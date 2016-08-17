package org.nanotek.dao.spring;

import org.nanotek.beans.TrackName;

public interface TrackNameDAO<T extends TrackName> {

	public T findById (String id);
}
