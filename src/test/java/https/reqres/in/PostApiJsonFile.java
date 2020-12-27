package https.reqres.in;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;

public class PostApiJsonFile {
	
	
	@Test
	public void post()
	{
		 Response post = given().auth().none().contentType(ContentType.JSON)
		.body(new File("./users.json")).when().post("https://reqres.in/api/users");
		
		post.prettyPrint();
		System.out.println(post.getStatusCode());
		System.out.println(post.getTime());
	}

}
