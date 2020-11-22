package map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class HashtableC {

	public static void main(String[] args) {
		
		
		Map<String, Integer> add = new Hashtable<String, Integer>();
		
		
		add.put("Mir", 101);
		add.put("Mamun", 102);
		add.put("Safwan", 103);
		System.out.println(add);
		
		System.out.println(add.entrySet());
		
		for(Entry<String, Integer> entry:add.entrySet())
		{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
		
		
		
		

	}

}
