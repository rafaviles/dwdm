package dwdm.intersection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class EntryTest {
	String[] testStrings = {
			"F00000000001",
			"K00000000257",
			"J00000000255",
			"D12345678912", 
			"A99999999999", 
			"Y00000000000"};
	

	@Test
	public void testToString() {
		for(String s : testStrings){
			Entry entry = new Entry(s);
			assertThat(entry.toString(), equalTo(s));
		}
	}
	

	
}
