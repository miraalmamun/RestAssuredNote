package oAuth2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import json_pojo.MainPojo;

public class Oauth2_Test3 {

	@Test
	public void simple() {

		String accessToken = "ya29.A0AfH6SMCBgUYjqOKoiA_-fq-FlSVEWMqzuKDv1PhTNIAz0xfh1daC6mG32adcg249D6HzdTjEIfr3Q84-Wjz0BoseCH-KOW0cY1cyXYP8a9ixQ1Yj1G_sGfrl4cBoHJlBt74_eWON5uPz6CWzPDbwOUlViZlqv5f1T_fXeEkOvs0t";

		@SuppressWarnings("unused")
		MainPojo mainclass = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(MainPojo.class);

		

	}

}
