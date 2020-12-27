package https.reqres.in;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest2 {
	
	@Test
	public void getMethod()
	{
		 Response getResponse = given().param("page","2").auth().none()
		.headers("Content-Type","application/json").contentType(ContentType.JSON)
		.when().get("https://reqres.in/api/users");
		
		 getResponse.prettyPrint();
		 System.out.println("Response is: "+getResponse.asString());
		 System.out.println("Response time is: "+getResponse.getTime());
		 System.out.println("Response code is: "+getResponse.statusCode());
	}

}
