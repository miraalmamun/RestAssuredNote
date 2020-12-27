package com.rahulshetty.google;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import payload.PayLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicCRUD2 {

	@Test
	public void cRUD() {

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
		     String placeId3 = path.get("place_id");
		     
		   System.out.println("Place Id=============================================# "+placeId);
		   System.out.println("Place Id=============================================# "+placeId3);
		   
		   
		  
		   
		   
		   String placeId2 = given().queryParam("key", "qaclick123")
				     .headers("Content-Type", "application/json")
						.contentType(ContentType.JSON)
						.body(PayLoad.addPlace())
						.when().post("/maps/api/place/add/json")
						.then().assertThat()
						.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)")
						.extract().response().path("place_id");
				     
				  
				     
		  System.out.println("Place Id2============================================# "+placeId2);
		   
		   
		   
		   
		   
		   
		   
		   
		   

			String latitude =
					 given().
					         queryParam("key", "qaclick123").
					         queryParam("place_id", "074ca2d65d70f3a0ecea7fb9149ff6ef").
					 when().
					         get("/maps/api/place/get/json").
					 then().
					         contentType(ContentType.JSON).
					         body("location.latitude", equalTo("-38.383494")).
					 extract().
					         path("location.latitude");

					 System.out.println("latitude: "+latitude);
		     
		     
		     
		     
	}

}






















