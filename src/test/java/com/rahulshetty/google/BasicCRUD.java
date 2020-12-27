package com.rahulshetty.google;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import payload.PayLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicCRUD {

	@Test
	public void cRUD() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		   /**
		    * Check status code 200, response body has "scope" equalTo "APP"
		    * and header contains key-value pairs Server=Apache/2.4.18 (Ubuntu)
		    */
		     given().log().all().queryParam("key", "qaclick123")
		     .headers("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.body(PayLoad.addPlace())
				.when().post("/maps/api/place/add/json")
				.then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)");
		     
		     //===================================================================================================
		     
		     
		     
		     
	}

}















