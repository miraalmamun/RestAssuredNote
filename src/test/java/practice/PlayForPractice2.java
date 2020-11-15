package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PlayForPractice2 {

	@Test
	public void testingTest() {
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		RestAssured.given().log().all().header("Content-Type","application")
		.queryParam("place_id","a0509f2510e636398fa84a5feb49bf0a").when()
		.get("maps/api/place/get/json").then().assertThat().statusCode(200);
		
		
		
		
		

	}

}














