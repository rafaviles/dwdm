package dwdm.intersection;

public class Utils {
	
	private static final long prime = 47_055_833_459L;
	
	private static final long a = 37_329_742;
	private static final long b = 98_272_284;
	
	private static final int chunks = 24;
	
	public int hashLong(long x){
		return (int) ((((a*x) + b) % prime) % chunks);
	}

}
