package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class Medium implements Base<Long>{

	private Long id; 
	private Long mediumId; 
	private Long release; 
	private Long position;
	private Long format; 
	private String name; 
	private Long trackCount; 
	

	@Override
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getMediumId() {
		return mediumId;
	}


	public void setMediumId(Long mediumId) {
		this.mediumId = mediumId;
	}
	

	public Long getTrackCount() {
		return trackCount;
	}


	public void setTrackCount(Long trackCount) {
		this.trackCount = trackCount;
	}


	public Long getRelease() {
		return release;
	}


	public void setRelease(Long release) {
		this.release = release;
	}


	public Long getPosition() {
		return position;
	}


	public void setPosition(Long position) {
		this.position = position;
	}


	public Long getFormat() {
		return format;
	}


	public void setFormat(Long format) {
		this.format = format;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mediumId == null) ? 0 : mediumId.hashCode());
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
		Medium other = (Medium) obj;
		if (mediumId == null) {
			if (other.mediumId != null)
				return false;
		} else if (!mediumId.equals(other.mediumId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Medium [id=" + id + ", mediumId=" + mediumId + ", trackCount="
				+ trackCount + ", release=" + release + ", position=" + position
				+ ", format=" + format + ", name=" + name + "]";
	}

	
}
