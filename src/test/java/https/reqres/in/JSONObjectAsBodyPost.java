package https.reqres.in;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JSONObjectAsBodyPost {
	
	
	JSONObject payload = new JSONObject();
	
	
	@SuppressWarnings("unchecked")
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
