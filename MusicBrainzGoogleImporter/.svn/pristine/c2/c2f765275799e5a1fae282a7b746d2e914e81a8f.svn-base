package org.nanotek.base;

import java.util.List;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class ScannedOffice implements Base<Number> {

	private Number id; 
	private String normalizedName; 
	private String officeUrl; 
	private List<String> officeData; 
	
	
	
	public ScannedOffice() {
		id = System.nanoTime();
	}

	@Override
	public Number getId() {
		return id;
	}

	@Override
	public void setId(Number id) {
		this.id = id; 
	}

	public String getNormalizedName() {
		return normalizedName;
	}

	public void setNormalizedName(String normalizedName) {
		this.normalizedName = normalizedName;
	}

	public String getOfficeUrl() {
		return officeUrl;
	}

	public void setOfficeUrl(String officeUrl) {
		this.officeUrl = officeUrl;
	}

	public List<String> getOfficeData() {
		return officeData;
	}

	public void setOfficeData(List<String> officeData) {
		this.officeData = officeData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((normalizedName == null) ? 0 : normalizedName.hashCode());
		result = prime * result
				+ ((officeUrl == null) ? 0 : officeUrl.hashCode());
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
		ScannedOffice other = (ScannedOffice) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (normalizedName == null) {
			if (other.normalizedName != null) {
				return false;
			}
		} else if (!normalizedName.equals(other.normalizedName)) {
			return false;
		}
		if (officeUrl == null) {
			if (other.officeUrl != null) {
				return false;
			}
		} else if (!officeUrl.equals(other.officeUrl)) {
			return false;
		}
		return true;
	}
	
	

}
