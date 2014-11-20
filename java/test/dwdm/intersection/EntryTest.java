package dwdm.intersection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class EntryTest {
	String[] testStrings = {
			"F0000000001",
			"K0000000027",
			"J0000000025",
			"D1234567892", 
			"A9999999999", 
			"Y0000000000",
			"I5328062530"};
	

	@Test
	public void testToString() {
		for(String s : testStrings){
			Entry entry = new Entry(s);
			assertThat(entry.toString(), equalTo(s));
		}
	}
	
	@Test
	public void testBinaryRespresentation(){
		for(String s : testStrings){
			Entry entry1 = new Entry(s);
			Entry entry2 = new Entry(entry1.getData(), 0);
			assertEquals(entry1, entry2);
			assertEquals(s, entry2.toString());
		}
	}
	

	
}
