package practice;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;



public class StartRestPlay {

	@Test
	public void play() {
		
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		/*
		String s= given().log().all().queryParam("key", "qaclick123")
		    .header("Content-Type","application/json")
			.body(PayLoad.addPlace())
		    
			.when().post("maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200)
			.body("scope",equalTo("APP")).header("Server","Apache/2.4.18 (Ubuntu)")
			.extract().response().asString();
		System.out.println(s);
		System.out.println("===================================");
		*/
		
		//"name": "Frontline house"
		String getPlaceById = RestAssured.given().log().all().header("Content-Type", "application/json")
				.queryParam("key", "qaclick123")
				.queryParam("place_id","a0509f2510e636398fa84a5feb49bf0a").when()
				.get("maps/api/place/get/json").then().assertThat().log().all()
				.body("name",equalTo("Frontline house")).header("Server","Apache/2.4.18 (Ubuntu)")
				.statusCode(200).extract().response().asString();
		System.out.println("=========================Get place by id: "+getPlaceById);
}
}
