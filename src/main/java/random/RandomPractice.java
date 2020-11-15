package random;

public class RandomPractice {
	
	public static String ALPHA_NUM = "abcdefghijklmnopqrstuvwxyz";
	
	public static String randomStringGenerate(int length)
	{   
		StringBuffer sb = new StringBuffer(length);
		for(int i=0;i<length;i++)
		{
			int ndx = (int)(Math.random()*ALPHA_NUM.length());
			sb.append(ALPHA_NUM.charAt(ndx));
			
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		
             System.out.println(randomStringGenerate(4));
	}

}
