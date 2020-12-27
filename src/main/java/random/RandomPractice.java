package random;

public class RandomPractice {

	static String ALPHA_CHAR = "abcdefghijklmnopqrstuvwxyz";
	static String ALPHA_NUM = "0123456789";

	public static void main(String[] args) {
		
		
       /*
		System.out.println(ALPHA_CHAR.length());
		System.out.println(ALPHA_CHAR.charAt(0));

		for (int i = 0; i < 100; i++) {

			double d = Math.random();
			System.out.println("Double: " + d);
			System.out.println("Index: " + d * ALPHA_CHAR.length());
			System.out.println((int) (d * ALPHA_CHAR.length()));
			System.out.println("====================================");
			
			*/
		
	   System.out.println(getRandomPassword(4, 2, 2));
		   
		    
		
		}
	
	
	
	
	  public static String getRandomPassword(int lower,int upper, int number)
	  {  
		 String a = getRandonStringLower(lower);
		 String b = getNumberString(number);
		 String c = getRandonStringUpper(upper);
		 String password = a+b+c;
		  return password;
	  }
	
	
	
	
	
	
	
	
	  public static String getRandonStringLower(int length)
	  {
		  StringBuffer sb = new StringBuffer(length);
		  
		  for(int i=0;i<length;i++)
		  {
			  int indx = (int) (Math.random()*ALPHA_CHAR.length());
			  sb.append(ALPHA_CHAR.charAt(indx));
		  }
		  
		  return sb.toString();
	  }
	
	  

	  public static String getRandonStringUpper(int length)
	  {
		  StringBuffer sb = new StringBuffer(length);
		  
		  for(int i=0;i<length;i++)
		  {
			  int indx = (int) (Math.random()*ALPHA_CHAR.length());
			  sb.append(ALPHA_CHAR.charAt(indx));
		  }
		  
		  return sb.toString().toUpperCase();
	  }
	
	
	  public static String getNumberString(int length)
	  {
		  StringBuffer sb = new StringBuffer(length);
		  
		  for(int i=0;i<length;i++)
		  {
			  int indx = (int) (Math.random()*ALPHA_NUM.length());
			  sb.append(ALPHA_NUM.charAt(indx));
		  }
		  
		  return sb.toString();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
