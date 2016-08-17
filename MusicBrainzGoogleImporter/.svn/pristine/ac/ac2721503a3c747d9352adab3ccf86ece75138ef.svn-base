package org.nanotek.lucene.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.Version;
import org.nanotek.StringKong;
import org.nanotek.base.Configuration;

@SuppressWarnings("serial")
public class SimpleFieldAnalyzer extends FieldAnalyzer implements Configuration<SimpleFieldAnalyzer> {
	
	public SimpleFieldAnalyzer(Version version,
			StringKong targetField, Analyzer analyzer) {
		super( version,
				 targetField,  analyzer);
		
	}
	
	@Override
	public SimpleFieldAnalyzer get()
	{ 
		return this;
	}

}
