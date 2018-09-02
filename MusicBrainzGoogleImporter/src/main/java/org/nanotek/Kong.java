package org.nanotek;

import java.io.Serializable;
import java.util.function.Supplier;

public interface Kong<K extends Serializable> extends Supplier<K> {

	@Override
	K get();

}
