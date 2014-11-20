package dwdm.intersection;

import static java.lang.Long.parseLong;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * "Compressed" representation of line in a file for join.
 * Note, no method can handle bad input, such as a line break at the end of
 * a string etc...
 * @author Christian Windolf
 *
 */
public class Entry {
	private static final NumberFormat format = new DecimalFormat("00000000000");
	
	private final byte[] data = new byte[6];
	
	public Entry(String entry){
		toByte(data, entry);
	}
	
	public static void toByte(byte[] array, String entry){
		array[0] = (byte) entry.charAt(0);
		long number = parseLong(entry.substring(1));
		array[5] = (byte) number;
		array[4] = (byte) (number >> 8);
		array[3] = (byte) (number >> 16);
		array[2] = (byte) (number >> 24);
		array[1] = (byte) (number >> 32);
	}
	
	public static void toByte(byte[] array, int offset, String entry){
		array[offset] = (byte) entry.charAt(0);
		long number = parseLong(entry.substring(1));
		array[offset + 5] = (byte) number;
		array[offset + 4] = (byte) (number >> 8);
		array[offset + 3] = (byte) (number >> 16);
		array[offset + 2] = (byte) (number >> 24);
		array[offset + 1] = (byte) (number >> 32);
	}

	
	public long getNumber(){
		long number = (( (long)  data[1] & 0xFFL) << 32);
		number += (( (long) data[2] & 0xFFL) << 24);
		number += (( (long) data[3] & 0xFFL) << 16);
		number += (( (long) data[4] & 0xFFL) << 8);
		number += ((long) data[5] & 0xFFL);
		return number;
	}
	
	
	
	@Override
	public String toString(){
		return ((char) data[0]) + format.format(getNumber());
	}

}
