package org.nanotek.util.generator;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileListReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath("C:", "/Users/josecanova/Downloads/mbdump.tar/mbdump/mbdump/"); 
		System.out.println(path.toFile().toString());
		for (String str:path.toFile().list()) 
			System.out.println(str);
	}

}
