package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class Recording implements Base<Long> {

	private Long id; 
	private Long recordingId; 
	private String gid; 
	private String name; 
	private Long artistCredit;
	private Long length;
	private String comment;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRecordingId() {
		return recordingId;
	}

	public void setRecordingId(Long recordingId) {
		this.recordingId = recordingId;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public Long getArtistCredit() {
		return artistCredit;
	}
	
	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((recordingId == null) ? 0 : recordingId.hashCode());
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
		Recording other = (Recording) obj;
		if (recordingId == null) {
			if (other.recordingId != null)
				return false;
		} else if (!recordingId.equals(other.recordingId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recording [id=" + id + ", recordingId=" + recordingId
				+ ", gid=" + gid + ", artistCredit=" + artistCredit + ", name="
				+ name + ", length=" + length + ", comment=" + comment + "]";
	}
	
}
