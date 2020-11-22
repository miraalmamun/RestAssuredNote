package pojo_class;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

public class Oauth2Test {

	@Test
	public void simple() throws Exception {
		
		/**
		 * Below url need to execte manually on the breowser 
		 */
		/*
		https://accounts.google.com/o/oauth2/v2/auth?scope=https:
		//www.googleapis.com/auth/userinfo.email&auth_url=https:
		//accounts.google.com/o/oauth2/v2/auth&client_id=
			692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type
			=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=mirmamun
         */
		
	
		String url = "https://rahulshettyacademy.com/getCourse.php?state=mirmamun&code=4%2F0AY0e-g4BTUEGphZsEUr1lJ0anhVjMPROSpuHvhD39A7HzTrRTWDKFpjtczUadB_7Xcy_eQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialcode = url.split("code=")[1];
		String code = partialcode.split("&scope")[0];
		

		String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code", code)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath jsp = new JsonPath(accessTokenResponse);
		String accessToken = jsp.getString("access_token");

		GetCourse gc = given().queryParam("access_token", accessToken)
				.expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getUrl());
		String title = gc.getCourses().getApi().get(1).getCourseTitle();
		System.out.println(title);
		 
		

	}

}
