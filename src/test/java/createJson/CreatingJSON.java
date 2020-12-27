package createJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreatingJSON {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		JSONObject obj = new JSONObject();
		obj.put("Name", "Mir");
		obj.put("place", "USA");
		System.out.println(obj.toJSONString());
		JSONObject obj2 = new JSONObject();
		obj2.put("Name", "Mamun");
		obj2.put("place", "UK");
		System.out.println(obj2.toJSONString());
		//result
		//{"place":"USA","Name":"Mir"}
		//{"place":"UK","Name":"Mamun"}
		
		
		JSONArray details = new JSONArray();
		details.add(obj);
		details.add(obj2);
		System.out.println(details);
		//Result
		//[{"place":"USA","Name":"Mir"},{"place":"UK","Name":"Mamun"}]
		
		JSONObject studentdetails = new JSONObject();
		studentdetails.put("students", details);
		System.out.println(studentdetails);
		//Result
		//{"students":[{"place":"USA","Name":"Mir"},{"place":"UK","Name":"Mamun"}]}
		
		
		
		
		
		
		

	}

}
