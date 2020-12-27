package https.reqres.in;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest {
	
	@Test
	public void getMethod()
	{
		 given().param("page","2").auth().none()
		.headers("Content-Type","application/json").contentType(ContentType.JSON)
		.when().get("https://reqres.in/api/users").then()
		.statusCode(200).body("page", equalTo(2),"per_page", equalTo(6)).log().all();
		
		
	}

}
