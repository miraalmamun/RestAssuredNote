package toolsQA;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get_Request {

	@Test
	public void get() {

		RestAssured.baseURI = "https://bookstore.demoqa.com";
	

		RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON);
		Response response = httpRequest.request(Method.GET, "/BookStore/v1/Books");
		
		
		
		String responseBodyAsString = response.getBody().asString();
		
		assertTrue(responseBodyAsString.contains("O'Reilly Media"));
		
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code: "+statusCode);
		
		Headers headers = response.getHeaders();
		//header('Content-type=application/json; charset=utf-8')
		System.out.println("All headers: "+ headers);
		
		
		
		int countOfHeaders = headers.asList().size();
		System.out.println("countOfHeaders: "+countOfHeaders);
		assertEquals(7, countOfHeaders);
		
		//headers.get("Content-Type=application/json; charset=utf-8");
		String headerValue = response.getHeader("Content-Type");
		System.out.println("headerValue: "+headerValue);
		
		assertEquals("application/json; charset=utf-8", headerValue);
		
		@SuppressWarnings("rawtypes")
		ResponseBody body = response.body().prettyPeek();
		System.out.println(body);
		System.out.println(body.asString());
		body.prettyPeek();
		System.out.println("========================================");
		
		@SuppressWarnings("rawtypes")
		ResponseBody body2 = response.getBody();
		System.out.println("String body is "+ body2.asString());
		body2.prettyPrint();
		
		
		

	}

}
