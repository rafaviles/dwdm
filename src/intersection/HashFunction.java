package intersection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * If we think of a Hash Table as an array then a hash function is used to
 * generate a unique key for eve ry item in the array. The position the item
 * goes in is known as the slot. Hashing doesn't work very well in situations in
 * which duplicate data is stored. Also it isn't good for searching for anything
 * except a specific key. However a Hash Table is a data structure that offers
 * fast insertion and searching capabilities.
 * 
 * @author Rafael Aviles
 * 
 */
public class HashFunction {
	
	private static final String DEFAULT_FILE1 = 
			"/Users/rafael/Documents/intersection/intersection/src/intersection/test.txt";
	private static final String DEFAULT_FILE2 =
			"/Users/rafael/Documents/intersection/intersection/src/intersection/text2.txt";
			

	static String[] theArray;

	static List<Long> ar1 = new ArrayList<Long>();
	static List<Long> ar2 = new ArrayList<Long>();

	public static void main(String[] args) throws FileNotFoundException {

		File file1;
		if(args.length < 1){
			file1 = new File(DEFAULT_FILE1);
		} else {
			file1 = new File(args[0]);
		}
		Scanner scan1 = new Scanner(file1);

		while (scan1.hasNextLine()) {
			String lino = (scan1.nextLine().substring(1));
			Long line = Long.parseLong(lino);
			ar1.add(line);
		}

		File file2;
		if(args.length < 2){
			file2 = new File(DEFAULT_FILE2);
		} else {
			file2 = new File(args[1]);
		}
		Scanner scan2 = new Scanner(file2);

		while (scan2.hasNextLine()) {
			String lino = (scan2.nextLine().substring(1));
			Long lina = Long.parseLong(lino);
			ar2.add(lina);
		}

		Collections.sort(ar1);
		Collections.sort(ar2);

		System.out.println(ar1);
		System.out.println(ar2);
		scan1.close();
		scan2.close();

		List<Long> list = new ArrayList<Long>();

		for (Long t : ar1) {
			if (ar2.contains(t)) {
				list.add(t);
			}
		}

		System.out.println(list);

	}

}