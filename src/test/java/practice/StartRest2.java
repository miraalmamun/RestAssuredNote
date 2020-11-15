package practice;

import io.restassured.RestAssured;
import payload.PayLoad;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class StartRest2 {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
	     given().log().all().queryParam("key", "qaclick123")
	    .header("Content-Type","application/json")
		.body(PayLoad.addPlace())
	    
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.body("scope",equalTo("APP")).header("Server","Apache/2.4.18 (Ubuntu)");
	     
	     
	     
  //Add place>update place with new address>Get place to validate if New address is present in response
       
	}

}
