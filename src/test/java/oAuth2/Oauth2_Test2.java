package oAuth2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import json_pojo.MainPojo;

public class Oauth2_Test2 {

	@Test
	public void simple() {

		String accessToken = "ya29.A0AfH6SMCBgUYjqOKoiA_-fq-FlSVEWMqzuKDv1PhTNIAz0xfh1daC6mG32adcg249D6HzdTjEIfr3Q84-Wjz0BoseCH-KOW0cY1cyXYP8a9ixQ1Yj1G_sGfrl4cBoHJlBt74_eWON5uPz6CWzPDbwOUlViZlqv5f1T_fXeEkOvs0t";

		MainPojo mainclass = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(MainPojo.class);

		System.out.println(mainclass.getInstructor());
		
		System.out.println(mainclass.getCourses().getApi().get(0));

		// There are lot of ways we can do it.

		// String responseBody = given().queryParam("access_token", accessToken).when()
		// .get("https://rahulshettyacademy.com/getCourse.php").asString();
		// System.out.println(responseBody);

	}

}
