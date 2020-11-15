package random;

import java.util.Random;

public class RandomGen {

	static String ALPHA_CHAR = "abcdefghijklmnopqrstuvwxyz";
	static String ALPHA_NUM = "1234567890";

	public static void main(String[] args) {

		System.out.println(randomNumberGenerator());
		System.out.println(randomNumberGenerator2());

	}

	public static String randomString(int length) {
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			int ndx = (int) (Math.random() * ALPHA_CHAR.length());
			// System.out.println("random numbers are--->" + ndx);
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
