package tests.org.nanotek.musicbrainz.data.load.csv.spring.musicbrainz;
//http://www.java2s.com/Code/Java/File-Input-Output/Mappinganentirefileintomemoryforreading.htm
import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFile {
	  public static void main(String[] args) throws Exception {
//	    if (args.length != 1) {
//	      System.out.println("argument: sourcefile");
//	      System.exit(1);
//	    }
		  String fileStr = "C:/java/music_brainz/mbdump.tar/mbdump/mbdump/recording";
	    long length = new File(fileStr).length();
	    MappedByteBuffer in = new FileInputStream(fileStr).getChannel().map(
	        FileChannel.MapMode.READ_ONLY, 0, length);
	    int i = 0;
	    while (in.remaining() > 0)
	      System.out.print((char) in.get(i++));
	    
	  }
	} ///:~