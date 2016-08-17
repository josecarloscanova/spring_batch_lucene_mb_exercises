package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class ReleaseGroup implements Base<Long> {

	private Long id; 
	private Long releaseGroupId; 
	private String gid; 
	private String name; 
	private Long artistCredit; 
	private Integer type;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
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
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	} 
	
	public Long getReleaseGroupId() {
		return releaseGroupId;
	}

	public void setReleaseGroupId(Long releaseGroupId) {
		this.releaseGroupId = releaseGroupId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((releaseGroupId == null) ? 0 : releaseGroupId.hashCode());
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
		ReleaseGroup other = (ReleaseGroup) obj;
		if (releaseGroupId == null) {
			if (other.releaseGroupId != null)
				return false;
		} else if (!releaseGroupId.equals(other.releaseGroupId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReleaseGroup [id=" + id + ", releaseGroupId=" + releaseGroupId
				+ ", gid=" + gid + ", name=" + name + ", artistCredit="
				+ artistCredit + ", type=" + type + "]";
	}
}
