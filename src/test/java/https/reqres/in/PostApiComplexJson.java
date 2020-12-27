package https.reqres.in;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostApiComplexJson {
	Map<String, Object> payload = new HashMap<String, Object>();
	@Test
	public void post()
	{    
		 payload.put("name", "morpheus");
		 payload.put("job", "leader");
		 List<String> l=new ArrayList<String>();
		 l.add("Java");
		 l.add("C");
		 payload.put("skills", l);
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("companyName", "XYZ");
		 map.put("emailId","msaq@gmail.com");
		 payload.put("details", map);
		 
		 Response post = given().auth().none().contentType(ContentType.JSON)
		.body(payload).log().all().when().post("https://reqres.in/api/users");
		 
		 System.out.println("Post Response is: "+post.asString());
		 System.out.println("Post Response code is: "+post.getStatusCode());
		
	}



}
