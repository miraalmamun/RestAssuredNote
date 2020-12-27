package https.reqres.in;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostApi2 {
	
	String payLoad = "{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"leader\"\r\n" + 
			"}";
	
	@Test
	public void post()
	{
		 Response post = given().auth().none().contentType(ContentType.JSON)
		.body(payLoad).when().post("https://reqres.in/api/users");
		
		post.prettyPrint();
		System.out.println(post.getStatusCode());
		System.out.println(post.getTime());
	}

}
