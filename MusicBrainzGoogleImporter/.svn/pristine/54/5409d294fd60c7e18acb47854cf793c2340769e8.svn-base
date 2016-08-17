package org.nanotek.lucene.config;

import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.Version;
import org.nanotek.StringKong;
import org.nanotek.base.Configuration;

@SuppressWarnings("serial")
public class MappedFieldAnalyzer extends FieldAnalyzer implements Configuration<MappedFieldAnalyzer>{

	private Map<String, Analyzer> fieldMapConfiguration;

	public MappedFieldAnalyzer(Version version,
			StringKong targetField, Analyzer analyzer) {
		super(version, targetField, analyzer);
	}
	
	public MappedFieldAnalyzer(Version version,
			StringKong targetField, Analyzer analyzer,Map<String,Analyzer> fieldAnalyzers) {
		super(version, targetField, analyzer);
		this.fieldMapConfiguration = fieldAnalyzers;
	}

	public Map<String, Analyzer> getFieldMapConfiguration() {
		return fieldMapConfiguration;
	}
	
	@Override
	public MappedFieldAnalyzer get()
	{ 
		return this;
	}
}
