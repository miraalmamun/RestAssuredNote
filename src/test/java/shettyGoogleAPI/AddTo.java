package shettyGoogleAPI;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddTo {
	
	@Test
	public void postMethod()
	{   
		MainPayLoad mpl = new MainPayLoad();
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		mpl.setLocation(l);
		mpl.setAccuracy(50);
		mpl.setAddress("142-20 Franklin Avenue, Flushing");
		mpl.setLanguage("French-IN");
		mpl.setWebsite("https:google.com");
		mpl.setName("Mir Mamun");
		mpl.setPhone_number("718-335-9584");
		List<String> typesArray = new ArrayList<String>();
		typesArray.add("Mir");
		typesArray.add("shop");
		mpl.setTypes(typesArray);
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String body = given().header("key", "qaclick123").body(mpl).log().all()
		.when().post("/maps/api/place/add/json").then().assertThat()
		.statusCode(200).extract().response().asString();
		System.out.println(body);
		
		//"place_id":"12bb7242248031f4d42b29410451425d"
		
	}

}
