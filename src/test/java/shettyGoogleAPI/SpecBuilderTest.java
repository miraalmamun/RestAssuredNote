package shettyGoogleAPI;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderTest {
	
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
		
		
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		RequestSpecBuilder rsb = new RequestSpecBuilder();
		RequestSpecification req = rsb.setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecBuilder respon = new ResponseSpecBuilder();
		ResponseSpecification responSpe = respon.expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		RequestSpecification httpRequest = given().spec(req).body(mpl);
		
		Response response = httpRequest.when().post("/maps/api/place/add/json");
		ValidatableResponse vResponse = response.then().spec(responSpe);
		
		String responseString = vResponse.extract().asString();
		System.out.println(responseString);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
