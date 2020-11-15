package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.PayLoad;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class StartRest3 {

	public static void main(String[] args) {
        
		 //Add place(POST)>update place(PUT) with new address>Get place(GET) to validate if New address is present in response
		
		 RestAssured.baseURI = "https://rahulshettyacademy.com";
		 String response = given().queryParam("key", "qaclick123")
	    .header("Content-Type","application/json")
		.body(PayLoad.addPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.body("scope",equalTo("APP")).header("server","Apache/2.4.18 (Ubuntu)")
		.extract().response().asString();
		System.out.println(response);
	     
	     //For parsing JSON we have JsonPath(class)
		JsonPath json = new JsonPath(response);
		String placeId = json.getString("place_id");
	     System.out.println(placeId);
	     
 
       
	}

}
