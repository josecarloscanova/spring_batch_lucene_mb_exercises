package org.nanotek.lucene.document.configuration;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.nanotek.PostConstructor;

@SuppressWarnings("serial")
public class AdjustableFieldConfiguration extends FieldConfiguration implements PostConstructor<FieldConfiguration>{


	public AdjustableFieldConfiguration() {
	}
	
	public AdjustableFieldConfiguration(FieldType ref) {
		postContruct (ref); 
	}

	public AdjustableFieldConfiguration(String id, String name, FieldType ref) {
		super(id, name);
		postContruct (ref); 
	}


	public AdjustableFieldConfiguration(String id, String name,
			DocumentConfiguration parentDocument , FieldType ref) {
		super(id, name, parentDocument);
		postContruct (ref); 
	}


	private void postContruct(FieldType ref) {
		
		this.indexed = ref.indexed();
	    this.store = (ref.stored())?Field.Store.YES:Field.Store.NO;
	    this.tokenized = ref.tokenized();
	    this.storeTermVector = ref.storeTermVectors();
	    this.storeOffsetWithTermVector = ref.storeTermVectorOffsets();
	    this.storePositionWithTermVector = ref.storeTermVectorPositions();
	    this.omitNorms = ref.omitNorms();
	    this.indexOptions = ref.indexOptions();
	    this.numericType = ref.numericType();
	    
	}
	
}
