package createJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSON {
 
	/*
	{
        "id": 1,
        "firstName": "Mir",
        "lastName": "Mamun",
        "email": "abc@gmail.com",
        "programme": "Manager",
       "courses": [
                     "Java",
                     "Selenium"
                   ]
                 			
    }
      */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		
		JSONObject obj=new JSONObject();
		obj.put("id",1);
		obj.put("firstName","Mir");
		obj.put("lastName","Mamun");
		obj.put("email","abc@gmail.com");
		obj.put("programme","Manager");
		System.out.println(obj);
		
		JSONArray courses=new JSONArray();
		courses.add("Java");
		courses.add("Selenium");
		obj.put("courses", courses);
		System.out.println(obj);
		
		System.out.println();
		System.out.println("======////=============================//==============");
		System.out.println();
		
		HashMap<String,Object> student = new HashMap<String,Object>();
		student.put("id",1);
		student.put("firstName","Mir");
		student.put("lastName","Mamun");
		student.put("email","abc@gmail.com");
		student.put("programme","Manager");
		System.out.println(obj);
		
		List<String> subject = new ArrayList<String>();
		subject.add("Java");
		subject.add("Selenium");
		student.put("courses", subject);
		System.out.println();
	

	}

}








