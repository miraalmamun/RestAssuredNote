package https.reqres.in;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class HashMapAsBodyPost {
	
	
	Map<String, String> payload = new HashMap<String, String>();
	
	
	@Test
	public void post()
	{    
		 payload.put("name", "morpheus");
		 payload.put("job", "leader");
		 given().auth().none().contentType(ContentType.JSON)
		.body(payload).when().post("https://reqres.in/api/users").then()
		.assertThat().body("name",equalTo("morpheus")).statusCode(201).log().all();
		
	}

}
