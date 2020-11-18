package toolsQA;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void createUserTest()
	{   
		String payLoad = "{\r\n" + 
				"  \"userName\": \"mimo98754\",\r\n" + 
				"  \"password\": \"Mimo@949658\"\r\n" + 
				"}";
		RestAssured.baseURI = "https://bookstore.toolsqa.com/";
		
		RequestSpecification httpRequest = RestAssured.given()
				.contentType(ContentType.JSON).body(payLoad);
		
		Response response = httpRequest.post("Account/v1/User");
		System.out.println("Response status code is: "+ response.getStatusCode());
		
		
	}

}
