package map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class MapInterface {

	public static void main(String[] args) {

		// "Us":"ford","kor":"kia","jpy":"nissan","eur":"ferrari","jpy":"toyota"

		//Map<String, String> add = new HashMap<String, String>();
		HashMap<String, String> add = new HashMap<String, String>();
		Hashtable<String, String> add2 = new Hashtable<String, String>();
		Properties add3 = new Properties();
		Properties add4 = new Properties();

		add.put("Us", "ford");
		add.put("kor", "kia");
		add.put("jpy", "nissan");
		add.put("eur", "ferari");
		add.put("jpy", "toyota");

		add2.put("Us", "ford");
		add2.put("kor", "kia");
		add2.put("jpy", "nissan");
		add2.put("eur", "ferari");
		add2.put("jpy", "toyota");

		add3.put("Us", "ford");
		add3.put("kor", "kia");
		add3.put("jpy", "nissan");
		add3.put("eur", "ferari");
		add3.put("jpy", "toyota");

		add4.put("Us", "ford");
		add4.put("kor", "kia");
		add4.put("jpy", "nissan");
		add4.put("eur", "ferari");
		add4.put("jpy", "toyota");

		System.out.println(add);
		System.out.println(add2);
		System.out.println(add3);

		System.out.println(add4.getProperty("Us"));

		System.out.println("=====================================");

		Set<Entry<String, String>> entry = add.entrySet();

		Iterator<Entry<String, String>> itr = entry.iterator();

		while (itr.hasNext()) {
			Entry<String, String> en = itr.next();

			// System.out.println("Key: "+en.getKey()+" Value: "+en.getValue());

			if (en.getKey().equals("eur")) {
				en.setValue("Mamun");
			}
		}

		for (Map.Entry<String, String> entry1 : add.entrySet()) {
			String k = entry1.getKey();
			String v = entry1.getValue();
			System.out.println("Key: " + k + ", Value: " + v);
		}
		System.out.println("==========================================");

		Set<Entry<String, String>> entry2 = add2.entrySet();

		Iterator<Entry<String, String>> itr2 = entry2.iterator();

		while (itr2.hasNext()) {
			Entry<String, String> en = itr2.next();

			// System.out.println("Key: "+en.getKey()+" Value: "+en.getValue());

			if (en.getKey().equals("eur")) {
				en.setValue("Mamun");
			}
		}

		for (Map.Entry<String, String> entry3 : add.entrySet()) {
			String k = entry3.getKey();
			String v = entry3.getValue();
			System.out.println("Key: " + k + ", Value: " + v);
		}

		System.out.println("==========================================");

		Set<Entry<Object, Object>> entry3 = add3.entrySet();

		Iterator<Entry<Object, Object>> itr3 = entry3.iterator();

		while (itr3.hasNext()) {
			Entry<Object, Object> en = itr3.next();

			// System.out.println("Key: "+en.getKey()+" Value: "+en.getValue());

			if (en.getKey().equals("eur")) {
				en.setValue("Mamun");
			}
		}

		for (Map.Entry<String, String> entry4 : add.entrySet()) {
			String k = entry4.getKey();
			String v = entry4.getValue();
			System.out.println("Key: " + k + ", Value: " + v);
		}

	}

}
