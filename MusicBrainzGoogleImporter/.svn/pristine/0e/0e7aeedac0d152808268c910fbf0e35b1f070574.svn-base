package org.nanotek.query.event;

import java.util.EventObject;

import org.nanotek.Event;
import org.nanotek.Identifiable;

@SuppressWarnings("serial")
public class QueryEvent<T> extends EventObject implements Event<T>,Identifiable<Long>{

	private Long id = 0L; 
	
	public QueryEvent(T source) {
		super(source);
		id = System.currentTimeMillis(); 
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getSource() {
		return (T) super.getSource();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		QueryEvent <?> other = (QueryEvent<?>) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
