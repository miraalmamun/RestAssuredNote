package toolsQA;

import static org.testng.Assert.assertTrue;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PracticeToolsQA {
	

	 
	@Test(enabled = false)
	public void basicAthentication()
	{   
		
		RestAssured.baseURI = "https://bookstore.demoqa.com";
		//https://bookstore.toolsqa.com
		//https://bookstore.demoqa.com
		String payLoad = "{\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\",\r\n" + 
				"  \"collectionOfIsbns\": [\r\n" + 
				"    {\r\n" + 
				"      \"isbn\": \"9781449331818\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		String credentialDetails = "mimo5252:Mimo@949658";
		
		byte[] encodedCredentials = Base64.encodeBase64(credentialDetails.getBytes());
		String encodedString = new String(encodedCredentials);
		System.out.println("Encoding String: "+encodedString);
		
		RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON)
				                          .header("Authorization","Basic "+encodedString);
		
		Response response = httpRequest.request().body(payLoad).post("/BookStore/v1/Books");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		
		
	}
	
	@Test(enabled = true)
	public void bearerAthentication()
	{   
		
		RestAssured.baseURI = "https://bookstore.demoqa.com";
		//https://bookstore.toolsqa.com
		//https://bookstore.demoqa.com
		
		String payLoadForAddBook = "{\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\",\r\n" + 
				"  \"collectionOfIsbns\": [\r\n" + 
				"    {\r\n" + 
				"      \"isbn\": \"9781449331818\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
		
		
		String payLoadForToken = "{\r\n" + 
				"  \"userName\": \"mimo5252\",\r\n" + 
				"  \"password\": \"Mimo@949658\"\r\n" + 
				"}";
		RequestSpecification httpRequest;
		Response response;
		
		httpRequest = RestAssured.given().contentType(ContentType.JSON);
		response = httpRequest.request().body(payLoadForToken).post("/Account/v1/GenerateToken");
		response.prettyPrint();
		String responseBodyAsString = response.getBody().asString();
		
		JsonPath jsonPath = JsonPath.from(responseBodyAsString);
		String getToken = jsonPath.get("token");
		System.out.println(getToken);
		
		httpRequest = RestAssured.given().contentType(ContentType.JSON)
				.header("Authorization","Bearer "+getToken);
		
		response = httpRequest.body(payLoadForAddBook).post("/BookStore/v1/Books");
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		assertTrue(response.getBody().asString().contains("9781449331818"));
		
	}
	

}

















