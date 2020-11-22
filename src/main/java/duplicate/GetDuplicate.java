package duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetDuplicate {

	public static void main(String[] args) {

		List<Integer> rollNumber = Arrays.asList(1,2,3,4,5,2,6,7);

		Set<Integer> uniqNumber = new HashSet<Integer>();
		Set<Integer> dupliIntegers = new HashSet<Integer>();
		
		for(int roll:rollNumber)
		{
			if(!uniqNumber.add(roll))
			{
				dupliIntegers.add(roll);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * System.out.println(uniqNumber); System.out.println(dupliIntegers);
		 * 
		 * List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 4, 5, 1);
		 * Set<Integer> targetSet = new HashSet<>(sourceList);
		 * System.out.println(targetSet);
		 * 
		 * 
		 */
	}

}
