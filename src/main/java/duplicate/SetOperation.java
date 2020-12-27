package duplicate;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetOperation {

	public static void main(String[] args) {

         
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		
		for(int i=11;i<513;i=i+21)
		{
			set.add(i);
		}
		
		System.out.println(set);
		//System.out.println(set);

	}

}
