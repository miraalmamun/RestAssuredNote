package random;

import java.util.Random;

public class RandomGen {

	static String ALPHA_CHAR = "abcdefghijklmnopqrstuvwxyz";
	static String ALPHA_NUM = "1234567890";

	public static void main(String[] args) {

		//System.out.println(randomNumberGenerator());
		//System.out.println(randomNumberGenerator2());
		System.out.println("randomString :"+randomString(5));
		//System.out.println("randomString2 :"+randomString2(5));
		//System.out.println("getRandomEmailId :"+ getRandomEmailId());

	}
	
	/**
	 * Math.random()
	 * random() is used to return a pseudorandom double type number greater than or equal
	 * to 0.0 and less than 1.0. The default random number always generated between 0 and
	 * 1. If you want to specific range of values, you have to multiply the returned value with
	 * the magnitude of the range.
	 * @param length
	 * @return
	 */
	

	/**
	 * Math.random()
	 * Returns a double value with a positive sign, greaterthan or equal to 0.0 and less than 1.0.
	 * Returned values are chosen pseudorandomly with (approximately)uniform distribution from that range. 
     * When this method is first called, it creates a single newpseudorandom-number generator, exactly as 
     * if by the expression new java.util.Random() This new pseudorandom-number generator is used thereafter
     *  forall calls to this method and is used nowhere else.  This method is properly synchronized to allow 
     *  correct use bymore than one thread. However, if many threads need to generatepseudorandom numbers at 
     *  a great rate, it may reduce contentionfor each thread to have its own pseudorandom-number generator.
     */
	
	/**
	 * A string buffer is like a String, but can be modified. At anypoint in time it contains some particular 
	 * sequence of characters, butthe length and content of the sequence can be changed through certainmethod calls. 
	 * The principal operations on a StringBuffer are the append and insert methods
	 */

	public static String randomString(int length) {
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			int ndx = (int) (Math.random() * ALPHA_CHAR.length());
			System.out.println("random numbers are--->" + ndx);
			sb.append(ALPHA_CHAR.charAt(ndx));

		}
		return sb.toString();

	}
	
	public static String randomString2(int length) {
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			int ndx = (int) (Math.random() * ALPHA_NUM.length());
			// System.out.println("random numbers are--->" + ndx);
			sb.append(ALPHA_NUM.charAt(ndx));

		}
		return sb.toString();

	}


	public static String getRandomEmailId() {
		String email = "";
		email = email + randomString(3) + "@" + randomString(3) + ".com";
		return email;
	}

	// ==========================================RANDOM DATA
	// GENERATORS====================================

	/**
	 * This method creates a random integer type number for making username and
	 * email to create an account.
	 * 
	 * @return int
	 */
	public static int randomNumberGenerator() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(1000);
	}
	
	public static String getNumberAsString() {

		Random random = new Random();
		int ranNumber = random.nextInt(1000);
		String stringNumber = Integer.toString(ranNumber);

		return stringNumber;
	}
	
	
	public static int randomNumberGenerator2()
	{
		 
			int min = 200;  
			int max = 400; 
			/*
			//Generate random double value from 200 to 400   
			System.out.println("Random value of type double between "+min+" to "+max+ ":");  
			double a = Math.random()*(max-min+1)+min;   
			System.out.println(a);  
			//Generate random int value from 200 to 400   
			System.out.println("Random value of type int between "+min+" to "+max+ ":");
			*/  
			int b = (int)(Math.random()*(max-min+1)+min);  
			  
			
			return b;
	}
	
	
	
	
	
	
	

}
