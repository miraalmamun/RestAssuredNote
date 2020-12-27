package sdet_CreateJSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Student {
	
	/**
	 * Serialization and Deserialization
	 */
	
	/**
	 * This class implement without Serialization and Deserialization
	 * HasMap concept using here
	 */
    
	/**
	 * {
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
	
	@SuppressWarnings("rawtypes")
	HashMap m = new HashMap();
	
	
	
	@SuppressWarnings("unchecked")
	@Test(priority = 1,enabled = true)
	public void hashMapConcept()
	{
		m.put("id", 101);
		m.put("firstName", "Mir");
		m.put("lastName", "Mamun");
		m.put("email", "abc@gmail.com");
		m.put("programme", "Manager");
		System.out.println(m);
		List<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("Selenium");
		System.out.println(course);
		m.put("courses", course);
		System.out.println(m);
		
		given().contentType(ContentType.JSON).body(m).log().all()
		.when().post("http://localhost:8085/student")
		.then().log().all().assertThat().statusCode(201)
		.body("msg", equalTo("Student added")).log().all();
		
	}
	@Test(priority = 2,enabled = true)
	void getStudentRecord()
	{
	
		
		given()
		.when()
		    .get("http://localhost:8085/student/101")
		.then()
		.assertThat()
		.body("id", equalTo(101)).log().all();
		
	}
	
	
}
