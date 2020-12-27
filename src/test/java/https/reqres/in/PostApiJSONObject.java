package https.reqres.in;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostApiJSONObject {
	
	JSONObject obj = new JSONObject();
	JSONObject obj2 = new JSONObject();
	JSONArray array = new JSONArray();
	
	@SuppressWarnings("unchecked")
	@Test
	public void post()
	{    
		obj.put("name", "Mamun");
		obj.put("job", "leader");
		array.add("Java");
		array.add("C");
		obj.put("skills", array);
		obj2.put("companyName", "XYZ");
		obj2.put("emailId", "msaq@gmail.com");
		obj.put("details", obj2);
		
		Response post = given().auth().none().contentType(ContentType.JSON)
		.body(obj.toString()).log().all().when().post("https://reqres.in/api/users");
		 
		
	
		System.out.println("Post Response is: "+post.asString());
		System.out.println("Post Response code is: "+post.getStatusCode());
		post.prettyPrint();
		
	}



}
