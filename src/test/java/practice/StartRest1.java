package practice;

import io.restassured.RestAssured;
import payload.PayLoad;

import static io.restassured.RestAssured.given;

public class StartRest1 {

	public static void main(String[] args) {

		// Validate if add Place Api is working as expected
		// RestAssurd works on three principle----->
		// Any RestAsssured tests should be written in these three principle only.
		// given-all input details
		// when-submit the API-Resource/http methods
		// Then validate the response

		// First set BaseURI
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(PayLoad.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat()
		.statusCode(200);

	}

}
