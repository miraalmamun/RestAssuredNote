package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class PlayForPractice {

	@Test
	public void testingTest() {
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		RequestSpecification rs = 
		 RestAssured.given().log().all().header("Content-Type","application/json")
		.queryParam("key","qaclick123").queryParam("place_id","a0509f2510e636398fa84a5feb49bf0a");
		
		
		Response response = 
				rs.when().log().all().get("maps/api/place/get/json");
				
		//ValidatableResponse  validate = 
			String validate = 	response.then().log().all()
					.body("language", equalTo("French-IN"))
					.statusCode(200).extract().response().asString();
		System.out.println(validate);
		
		

	}

}














