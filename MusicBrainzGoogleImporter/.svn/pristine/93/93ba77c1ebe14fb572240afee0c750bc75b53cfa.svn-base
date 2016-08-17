package org.nanotek.lucene.query.result;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;
import org.nanotek.AbstractBase;

@SuppressWarnings("serial")
public class ScoreDocBase extends AbstractBase<Long> {

	  /** The score of this document for the query. */
	  public float score;

	  /** A hit document's number.
	   * @see IndexSearcher#doc(int) */
	  public int doc;

	  /** Only set by {@link TopDocs#merge} */
	  public int shardIndex;
	  
	public ScoreDocBase(float score, int doc, int shardIndex) {
		super(System.nanoTime());
		this.score = score;
		this.doc = doc;
		this.shardIndex = shardIndex;
	}

	public ScoreDocBase(Long id) {
		super(id);
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getDoc() {
		return doc;
	}

	public void setDoc(int doc) {
		this.doc = doc;
	}

	public int getShardIndex() {
		return shardIndex;
	}

	public void setShardIndex(int shardIndex) {
		this.shardIndex = shardIndex;
	}


}
