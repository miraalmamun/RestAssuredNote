package practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class StartRest5_1 {
	@Test
	public void play() throws Exception {

		// This is the another version of 'StartRest4'. In StartRest5 class body method
		// getting data from .json file.

		String path = System.getProperty("user.dir") + "\\JSONFiles\\addPlace.json";

		File file = new File(path);

		FileReader reader = new FileReader(file);

		JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);

		System.out.println("=========================" + jsonObject);

		// Add place(POST)>update place(PUT) with new address>Get place(GET) to validate
		// if New address is present in response

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(jsonObject).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println(response);

	}

}
