package org.nanotek.base;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.nanotek.Base;

/**
 * Can be used as a "default Super class" on case of 
 * a more refine and complex class hierarchy. 
 * 
 * Refer: http://www.datanucleus.org/products/datanucleus/jdo/value_generation.html
 * 
 * @author josecanovamauger
 *
 * @param <T> Serializable Object that represents the ID (unique identifier) of 
 * any subclass. 
 * 
 */
@MappedSuperclass
@SuppressWarnings("serial")
//@EntityListeners(org.nanotek.base.date.jpa.LongBaseEventListener.class)
public abstract class LongBase implements Base<Long>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id; 
	
	@Version
	protected Timestamp recordCreationDate;
	
	public LongBase(){ 
	}
	
	public LongBase(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getRecordCreationDate() {
		return recordCreationDate;
	}

	public void setRecordCreationDate(Timestamp recordCreationDate) {
		this.recordCreationDate = recordCreationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((recordCreationDate == null) ? 0 : recordCreationDate
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LongBase other = (LongBase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (recordCreationDate == null) {
			if (other.recordCreationDate != null)
				return false;
		} else if (!recordCreationDate.equals(other.recordCreationDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LongBase [id=" + id + ", recordCreationDate="
				+ recordCreationDate + "]";
	}
	
}
