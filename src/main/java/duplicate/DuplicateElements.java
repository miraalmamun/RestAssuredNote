package duplicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElements {

	public static void main(String[] args) {
		
		List<String> elements=new ArrayList<>();
		elements.add("One");
		elements.add("Three");
		elements.add("Two");
		elements.add("Three"); /*Duplicate Element*/
		elements.add("Four");
		elements.add("Five");
		elements.add("Four"); 	/*Duplicate Element*/
		
		System.out.println("Elements : "+elements);
		
		
		Set<String> duplicateElements=new HashSet<>();
		
		Collections.sort(elements);
		System.out.println("==========="+elements);
		
		for (int i = 1; i < elements.size(); i++) {
			if(elements.get(i-1).equals(elements.get(i))){
				duplicateElements.add(elements.get(i));
			}
		}
		System.out.println("Duplicate Elements : "+duplicateElements);
		
		
		
		
		
		

	}

}
