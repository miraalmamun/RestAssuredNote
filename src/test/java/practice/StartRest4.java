package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.PayLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class StartRest4 {

	public static void main(String[] args) {

		// Add place(POST)>update place(PUT) with new address>Get place(GET) to validate
		// if New address is present in response

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println(response);

		// For parsing JSON we have JsonPath(class)
		JsonPath json = new JsonPath(response);
		String placeId = json.getString("place_id");
		System.out.println(placeId);

		String newAddress = "142 Frank, USA";

		// Update(PUT)
		RestAssured.given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.updatePlace(placeId, newAddress)).when().put("maps/api/place/update/json").then().log()
				.all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

		// Retrieve(GET) Data by Id

		String getPlaceById = RestAssured.given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", placeId).when().get("maps/api/place/get/json").then().assertThat().log().all()
				.statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(getPlaceById);
		System.out.println("********"+ js);
		String ActualAddress = js.getString("address");
		System.out.println(ActualAddress);

		Assert.assertEquals(ActualAddress, newAddress, "Testcase failed");
		
		
	}

}
