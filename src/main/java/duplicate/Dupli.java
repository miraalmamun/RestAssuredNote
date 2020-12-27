package duplicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dupli {

	public static void main(String[] args) {

		List<String> name = Arrays.asList("Mir", "Mamun", "Mir", "Safwan", "Sarfina", "Mir", "Mamun");
		List<String> name2 = Arrays.asList("Mir", "Mamun", "Mir", "Safwan", "Sarfina", "Mir", "Mamun");
		Collections.sort(name);
		System.out.println(name);

		Set<String> duplicateName = new HashSet<String>();
		for (int i = 1; i < name.size(); i++) {
			if (name.get(i - 1).equals(name.get(i))) {
				duplicateName.add(name.get(i - 1));

			}
		}
		
		
		for(String dup:duplicateName)
		{
			for(int i=0;i<name2.size();i++)
			{
				if(dup.equals(name2.get(i)))
				{
					System.out.println("The index of "+dup+" is "+i);
				}
			}
		}
		

	}

}
