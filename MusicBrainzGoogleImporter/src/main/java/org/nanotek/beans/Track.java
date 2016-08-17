package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class Track implements Base<Long> {

	private Long id; 
	private Long trackId; 
	private String gid;
	private Long recording; 
	private Long medium; 
	private Integer position; 
	private Integer number; 
	private String name; 
	private Long artistCredit; 
	private Long length;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getTrackId() {
		return trackId;
	}
	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public Long getRecording() {
		return recording;
	}
	public void setRecording(Long recording) {
		this.recording = recording;
	}
	
	public Long getMedium() {
		return medium;
	}
	public void setMedium(Long medium) {
		this.medium = medium;
	}
	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getArtistCredit() {
		return artistCredit;
	}
	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
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
		result = prime * result + ((trackId == null) ? 0 : trackId.hashCode());
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
		Track other = (Track) obj;
		if (trackId == null) {
			if (other.trackId != null)
				return false;
		} else if (!trackId.equals(other.trackId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Track [id=" + id + ", trackId=" + trackId + ", gid=" + gid
				+ ", recording=" + recording + ", medium=" + medium
				+ ", position=" + position + ", number=" + number + ", name="
				+ name + ", artistCredit=" + artistCredit + ", lenght="
				+ length + "]";
	}
	
	
	

}
