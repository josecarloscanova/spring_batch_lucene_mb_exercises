package org.nanotek.beans;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class ArtistCredit implements Base<Long> {

	private Long id;
	private Long artistCreditId;
	private String name; 
	private Long artistCount; 
	private Long refCount;
//	private String created; 
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public Long getArtistCreditId() {
		return artistCreditId;
	}

	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getArtistCount() {
		return artistCount;
	}

	public void setArtistCount(Long artistCount) {
		this.artistCount = artistCount;
	}

	public Long getRefCount() {
		return refCount;
	}

	public void setRefCount(Long refCount) {
		this.refCount = refCount;
	}

	@Override
	public String toString() {
		return "ArtistCredit [id=" + id + ", artistCreditId=" + artistCreditId
				+ ", name=" + name + ", artistCount=" + artistCount
				+ ", refCount=" + refCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((artistCreditId == null) ? 0 : artistCreditId.hashCode());
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
		ArtistCredit other = (ArtistCredit) obj;
		if (artistCreditId == null) {
			if (other.artistCreditId != null)
				return false;
		} else if (!artistCreditId.equals(other.artistCreditId))
			return false;
		return true;
	}
	
}
