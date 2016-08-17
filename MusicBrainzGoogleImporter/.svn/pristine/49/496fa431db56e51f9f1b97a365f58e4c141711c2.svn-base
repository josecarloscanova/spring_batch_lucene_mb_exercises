package org.nanotek.lucene.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.shingle.ShingleFilter;
import org.apache.lucene.util.Version;
import org.nanotek.StringKong;

@SuppressWarnings("serial")
public class ShingleFieldAnalyzer extends FieldAnalyzer{
    /**
	 * 
	 */
	int minShingleSize;
    int maxShingleSize;
    String tokenSeparator;
    boolean outputUnigrams;
    boolean outputUnigramsIfNoShingles;
    String fillerToken;
    
	public ShingleFieldAnalyzer(Version version, StringKong targetField,
			Analyzer analyzer) {
		super(version, targetField, analyzer);
	}
    
	public ShingleFieldAnalyzer(Analyzer defaultAnalyzer,StringKong targetField,Version version) {
	    this(defaultAnalyzer, ShingleFilter.DEFAULT_MAX_SHINGLE_SIZE, targetField, version);
	  }

	  public ShingleFieldAnalyzer(Analyzer defaultAnalyzer, int maxShingleSize,StringKong targetField,Version version) {
		  this(defaultAnalyzer, ShingleFilter.DEFAULT_MIN_SHINGLE_SIZE, maxShingleSize, targetField, version);
	  }

	  public ShingleFieldAnalyzer(Analyzer defaultAnalyzer, int minShingleSize, int maxShingleSize , StringKong targetField, Version version) {
		  this(defaultAnalyzer, minShingleSize, maxShingleSize, ShingleFilter.DEFAULT_TOKEN_SEPARATOR,
	         true, false, ShingleFilter.DEFAULT_FILLER_TOKEN, targetField, version);
	  }

	  
	  public ShingleFieldAnalyzer(
		      Analyzer analyzer,
		      int minShingleSize,
		      int maxShingleSize,
		      String tokenSeparator,
		      boolean outputUnigrams,
		      boolean outputUnigramsIfNoShingles,
		      String fillerToken,
		      StringKong targetField,
		      Version version) {
     
		    super(version, targetField, analyzer);

		    if (maxShingleSize < 2) {
		      throw new IllegalArgumentException("Max shingle size must be >= 2");
		    }
		    this.maxShingleSize = maxShingleSize;

		    if (minShingleSize < 2) {
		      throw new IllegalArgumentException("Min shingle size must be >= 2");
		    }
		    if (minShingleSize > maxShingleSize) {
		      throw new IllegalArgumentException
		        ("Min shingle size must be <= max shingle size");
		    }
		    this.minShingleSize = minShingleSize;

		    this.tokenSeparator = (tokenSeparator == null ? "" : tokenSeparator);
		    this.outputUnigrams = outputUnigrams;
		    this.outputUnigramsIfNoShingles = outputUnigramsIfNoShingles;
		    this.fillerToken = fillerToken;
		  }	  
	  
	public int getMinShingleSize() {
		return minShingleSize;
	}

	public void setMinShingleSize(int minShingleSize) {
		this.minShingleSize = minShingleSize;
	}

	public int getMaxShingleSize() {
		return maxShingleSize;
	}

	public void setMaxShingleSize(int maxShingleSize) {
		this.maxShingleSize = maxShingleSize;
	}

	public String getTokenSeparator() {
		return tokenSeparator;
	}

	public void setTokenSeparator(String tokenSeparator) {
		this.tokenSeparator = tokenSeparator;
	}

	public boolean isOutputUnigrams() {
		return outputUnigrams;
	}

	public void setOutputUnigrams(boolean outputUnigrams) {
		this.outputUnigrams = outputUnigrams;
	}

	public boolean isOutputUnigramsIfNoShingles() {
		return outputUnigramsIfNoShingles;
	}

	public void setOutputUnigramsIfNoShingles(boolean outputUnigramsIfNoShingles) {
		this.outputUnigramsIfNoShingles = outputUnigramsIfNoShingles;
	}

	public String getFillerToken() {
		return fillerToken;
	}

	public void setFillerToken(String fillerToken) {
		this.fillerToken = fillerToken;
	}
	

}
