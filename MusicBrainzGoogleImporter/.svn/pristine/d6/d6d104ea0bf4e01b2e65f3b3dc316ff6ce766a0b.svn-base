package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class Isrc implements Base<Long> {

	private Long id; 
	private Long isrcId; 
	private Long recording; 
	private String source; 
	private String isrc; 
	
	
	public Isrc() {}

	@Override
	public Long getId() {
		return id;
	}
	
	public Long getIsrcId() {
		return isrcId;
	}

	public void setIsrcId(Long isrcId) {
		this.isrcId = isrcId;
	}

	public Long getRecording() {
		return recording;
	}
	
	public void setRecording(Long recording) {
		this.recording = recording;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIsrc() {
		return isrc;
	}

	public void setIsrc(String isrc) {
		this.isrc = isrc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isrcId == null) ? 0 : isrcId.hashCode());
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
		Isrc other = (Isrc) obj;
		if (isrcId == null) {
			if (other.isrcId != null)
				return false;
		} else if (!isrcId.equals(other.isrcId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Isrc [id=" + id + ", isrcId=" + isrcId + ", recording="
				+ recording + ", source=" + source + ", isrc=" + isrc + "]";
	}

	
}
