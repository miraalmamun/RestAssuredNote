package duplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DuplicateElements2 {

	public static void main(String[] args) {

		List<String> elements = new ArrayList<>();
		elements.add("One");
		elements.add("Three");
		elements.add("Two");
		elements.add("Three"); /* Duplicate Element */
		elements.add("Four");
		elements.add("Five");
		elements.add("Four"); /* Duplicate Element */

		System.out.println("Elements : " + elements);

		Set<String> set = new HashSet<>();
		Set<String> duplicateElements = new HashSet<>();

		for (String element : elements) {
			if (!set.add(element)) {
				duplicateElements.add(element);
			}
		}

		System.out.println("Uniq Elements : " + set);
		System.out.println("Duplicate Elements : " + duplicateElements);

		for (int i = 0; i < elements.size(); i++) {
			String listElement = elements.get(i);

			Iterator<String> itr = duplicateElements.iterator();

			while (itr.hasNext()) {
				String setElement = itr.next();

				if (listElement.equals(setElement)) {

					System.out.println("Index of " + elements.get(i) + " is " + i);
				}

			}

		}

	}

}
