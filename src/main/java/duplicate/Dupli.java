package duplicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dupli {

	public static void main(String[] args) {

		List<String> name = Arrays.asList("Mir", "Mamun", "Mir", "Safwan", "Sarfina", "Mir");
		List<String> name2 = Arrays.asList("Mir", "Mamun", "Mir", "Safwan", "Sarfina", "Mir");
		Collections.sort(name);

		String duplicateName = "";
		for (int i = 1; i < name.size(); i++) {
			if (name.get(i - 1).equals(name.get(i))) {
				duplicateName = name.get(i - 1);

			}
		}

		for (int i = 0; i < name.size(); i++) {
			
			if (name2.get(i).equals(duplicateName)) {
				System.out.println(i);
			}
		}

	}

}
