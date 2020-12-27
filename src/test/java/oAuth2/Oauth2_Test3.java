package oAuth2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import json_pojo.MainPojo;

public class Oauth2_Test3 {

	@Test
	public void simple() {

		String accessToken = "ya29.a0AfH6SMDhT2pMGmGbhG6Jk2Ljg5mIq6XKwOlJt6yy2AVrQwz8JDb5hi0nkcLDfg7DLuaEd1uvFW-75Pp5M8L_3JEbfqmHhV56N0tiqQ7xVFXrJ8puoWXvNDDROoxo95OrDrLbgrTtR_M8icMecP3u0LbtgnWD81-uGrrWHaRFPi2gaA";

		
		@SuppressWarnings("unused")
		MainPojo mainclass = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(MainPojo.class);

		

	}

}
