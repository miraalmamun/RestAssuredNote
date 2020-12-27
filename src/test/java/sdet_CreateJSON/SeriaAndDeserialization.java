package sdet_CreateJSON;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SeriaAndDeserialization extends Before {
	
	
	@Test(priority = 1,enabled = true)
	public void serializationTest()
	{
		
		RestAssured.given().contentType(ContentType.JSON).body(Before.serialization())
		.when().post("http://localhost:8085/student")
		.then().log().all().assertThat().statusCode(201)
		.body("msg",equalTo("Student added") );
		
	}
	
	@Test(priority = 1,enabled = true)
	public void deSerializationTest()
	{
		
		Stdnt as = RestAssured.given()
		.when().get("http://localhost:8085/student/101").as(Stdnt.class);
		
		System.out.println(as.getCourses().get(0));
		
	}

}
