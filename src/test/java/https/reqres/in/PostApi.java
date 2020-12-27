package https.reqres.in;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostApi {
	
	String payLoad = "{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"leader\"\r\n" + 
			"}";
	
	@Test
	public void post()
	{
		 given().auth().none().contentType(ContentType.JSON)
		.body(payLoad).when().post("https://reqres.in/api/users")
		.then().statusCode(201).body("name",equalTo("morpheus"));
		
		
	}

}
