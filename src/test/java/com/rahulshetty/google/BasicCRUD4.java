package com.rahulshetty.google;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import payload.PayLoad;
import random.RandomGen;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicCRUD4 {

	@Test
	public void cRUD() {
		
		
		String address = RandomGen.getNumberAsString()+" Franklin avenue USA.";
		System.out.println(address);

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		     String responseBodyString = given().queryParam("key", "qaclick123")
		     .headers("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.body(PayLoad.addPlace())
				.when().post("/maps/api/place/add/json")
				.then().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)")
				.extract().response().asString();
		     
		     JsonPath path = new JsonPath(responseBodyString);
		     String placeId = path.getString("place_id");
		
		     given().contentType(ContentType.JSON).body(PayLoad.updatePlace(placeId,address))   
		     .when().put("/maps/api/place/update/json").then().assertThat()
		     .body("msg",equalTo("Address successfully updated"));
		    
		     
		     given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.contentType(ContentType.JSON)
				.when().get("/maps/api/place/get/json")
				.then().assertThat()
				.statusCode(200).body("address", equalTo(address))
				.header("Server", "Apache/2.4.18 (Ubuntu)");
		     
		     
	}

}






















