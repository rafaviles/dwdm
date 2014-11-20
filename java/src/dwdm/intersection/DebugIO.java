package dwdm.intersection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class DebugIO {
	static Pattern pattern = Pattern.compile("\\w\\d+");
	
	public static void main(String[] args) throws IOException{
		File input = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(input));
		
		String line = reader.readLine();
		ChunkWriter chunkWriter = new ChunkWriter(new File("."), 1);
		while(line != null){
			int index = chunkWriter.getNextIndex();
			Entry.toByte(chunkWriter.buffer, index, line);
			
			line = reader.readLine();
			if(line == null){
				System.out.println(index);
			}
		}
		chunkWriter.close();
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("copy.txt")));
		List<Entry> list = Utils.read(new FileInputStream(new File("chunk01.cpr")));
		for(Entry e: list){
			writer.write(e.toString());
			writer.newLine();
		}
		writer.close();
	}
	

}
