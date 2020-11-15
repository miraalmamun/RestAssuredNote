package prac2;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import payload.PayLoad;


public class Prac2 {

	public static void main(String[] args) {
		// Add post
		// BaseURI---->https://rahulshettyacademy.com
		// Add place(post)Resource: /maps/api/place/add/json?key=qaclick123

		
        RestAssured.baseURI = "https://rahulshettyacademy.com";
		
        RequestSpecification rs = RestAssured.given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(PayLoad.addPlace());
        
		Response response = rs.when().post("/maps/api/place/add/json");
		
		ValidatableResponse vr = response.then().log().all().assertThat()
		.statusCode(200).header("Server", "Apache/2.4.18 (Ubuntu)")
		.body("scope",equalTo("APP"));
		
		String responseBody = vr.extract().response().asString();
		
		System.out.println("Response body: "+responseBody);
		
		JsonPath js = new JsonPath(responseBody);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		// Update put
		// https://rahulshettyacademy.com/maps/api/place/update/json?key=qaclick123
		
		Response res = RestAssured.given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(PayLoad.updateBody(placeId)).when().put("/maps/api/place/update/json");
		
		String s = res.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("======= "+s+" =========");
		
		System.out.println("==================================================");
		// Fetch data get
		// https://rahulshettyacademy.com/maps/api/place/get/json?key=qaclick123&place_id=bf478dadd9d89c423044e534c9eddcd1

		Response res2 = RestAssured.given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id",placeId).header("Content-Type", "application/json")
				.body(PayLoad.updateBody(placeId)).when().get("/maps/api/place/get/json");
				
				String s2 = res2.then().assertThat().statusCode(200).extract().response().asString();
				System.out.println("======= "+s2+" =========");
		
		
		
		
		
		
		
		
		
		
		
		

		// Fetch data get
		// https://rahulshettyacademy.com/maps/api/place/get/json?key=qaclick123&place_id=bf478dadd9d89c423044e534c9eddcd1

		// Query-Parameter==>key-qaclick123
		// Header--->Content-Type-application/json

		// This API Will add new place into Server

		// Complete URL : https://rahulshettyacademy.com/maps/api/place/add/json?key=
		// qaclick123

		// Base URL: https://rahulshettyacademy.com
		// Resource: /maps/api/place/add/json
		// Query Parameters: key =qaclick123

		// "msg": "Address successfully updated"
		/**
		 * { "place_id":"e5e4f53e7e7c82aad9fa5361d1d4b722", "address":"Bangladesh, USA",
		 * "key":"qaclick123" }
		 */

	}

}
