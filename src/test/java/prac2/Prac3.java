package prac2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;

public class Prac3 {

	public static void main(String[] args) {
		// Add post
		// BaseURI---->https://rahulshettyacademy.com
		// Add place(post)Resource: /maps/api/place/add/json
		// Query Parameters: key =qaclick123

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String body = "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Dream house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"Bangladesh,Bera,Pabna\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"https://miraalmamun.com\",\r\n" + 
				"  \"language\": \"Bangla-IN\"\r\n" + 
				"    \r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"";
		
		RequestSpecification rs = RestAssured.given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json").body(body);
		
		Response response = rs.when().post("/maps/api/place/add/json");
		
		String s = response.then().log().all()
				.statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)")
				.extract().response().asString();
		System.out.println("======== "+s);
		
		JsonPath jpath = new JsonPath(s);
		String placeId = jpath.getString("place_id");
		System.out.println(placeId);
		// Update put
		// https://rahulshettyacademy.com/maps/api/place/update/json?key=qaclick123
		
		String newAddress = "Flushing,NY,USA";
		String language = "French-IN";
		//French-IN
		
		String upDateBody = "{\r\n" + 
				"  \"place_id\": \""+placeId+"\",\r\n" + 
				"  \"address\": \""+newAddress+"\",\r\n" + 
				"  \"language\": \""+language+"\",\r\n" + 
				"  \"key\": \"qaclick123\"\r\n" + 
				"}";
		
		
		RequestSpecification rs2 = RestAssured.given().log().all().queryParam("key", "qaclick123")
				.body(upDateBody);
		
		Response response2 = rs2.when().put("/maps/api/place/update/json");
		ValidatableResponse vs = response2.then().log().all().statusCode(200)
				.header("Server", "Apache/2.4.18 (Ubuntu)")
				.body("msg", equalTo("Address successfully updated"));
		
		String s2 = vs.extract().response().asString();
		
		JsonPath jpath2 = new JsonPath(s2);
		String actualMsg = jpath2.getString("msg");
		Assert.assertEquals(actualMsg, "Address successfully updated");
        // Fetch data get
		// https://rahulshettyacademy.com/maps/api/place/get/json?key=qaclick123&place_id=bf478dadd9d89c423044e534c9eddcd1

		
		RequestSpecification rs3 = RestAssured.given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id",placeId);
		
		
		Response response3 = rs3.when().get("/maps/api/place/get/json");
		
		ValidatableResponse vr3 = response3.then().assertThat().statusCode(200)
				.body("address",equalTo(newAddress)).body("language",equalTo(language));
		String s3 = vr3.extract().response().asString();
		JsonPath jpath3 = new JsonPath(s3);
		String newAdd = jpath3.getString("address");
		Assert.assertEquals(newAdd, newAddress);
		String lan = jpath3.getString("language");
		System.out.println(lan);
		//Assert.assertEquals(lan, language);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Fetch data get
		// https://rahulshettyacademy.com/maps/api/place/get/json?key=qaclick123&place_id=bf478dadd9d89c423044e534c9eddcd1

		// Query-Parameter==>key-qaclick123
		// Header--->Content-Type-application/json

		// This API Will add new place into Server

		// Complete URL : https://rahulshettyacademy.com/maps/api/place/add/json?key=
		// qaclick123

		// Base URL: https://rahulshettyacademy.com
		// Resource: /maps/api/place/add/json
		

		// "msg": "Address successfully updated"
		/**
		 * { "place_id":"e5e4f53e7e7c82aad9fa5361d1d4b722", "address":"Bangladesh, USA",
		 * "key":"qaclick123" }
		 */

	}

}
