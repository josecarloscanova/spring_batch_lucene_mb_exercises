package org.nanotek;

import java.io.Serializable;

public interface Kong<K extends Serializable> extends Serializable {

	K get();

}
