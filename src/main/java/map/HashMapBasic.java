package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapBasic {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("101", "Safwan");
		map.put("102", "Mamaun");
		map.put("109", "Protiva");
		map.put("103", "Sarfina");
		map.put("104", "Mossarrof");
		map.put("105", "Hamidul");
		map.put("106", "Zakir");
		map.put("107", "Bakir");
		map.put("108", "Sadat");

		System.out.println("Map "+map);

		Set<Entry<String, String>> entry = map.entrySet();
		
		System.out.println("Entry "+entry);

		for (Entry<String, String> en : entry) {

			String key = en.getKey();
			String value = en.getValue();
			System.out.println("Key: " + key + " Value: " + value);
		}

		Collection<String> c = map.values();
		System.out.println("Values: "+c);

		for (String c2 : c) {
			System.out.println(c2);
		}

		Set<String> s = map.keySet();

		for (String s2 : s) {
			System.out.println(s2);
		}

		Set<Entry<String, String>> st = map.entrySet();

		System.out.println(c);
		System.out.println(s);
		System.out.println(st);

	}

}
