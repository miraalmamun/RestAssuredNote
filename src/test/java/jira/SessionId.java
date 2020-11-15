package jira;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.PayLoad;



public class SessionId {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void sessionAuth()
	{
		
		RestAssured.baseURI = "https://almamunmir.atlassian.net/";
		JSONObject json = new JSONObject();
		json.put("username","almamunmir79@gmail.com");
		json.put("password","Mimo949658");
		
		Response responseBody = RestAssured.given().header("Content-Type","application/json")
		.body(json).post("rest/auth/1/session");
		
		System.out.println(responseBody.getStatusCode());
		System.out.println(responseBody.getBody().jsonPath().prettify());
		System.out.println(responseBody.getCookies().get("JSESSIONID"));
		
		String sessionId = responseBody.getCookies().get("JSESSIONID");
		
		Response responseBody2 = RestAssured.given().contentType(ContentType.JSON)
		.cookie("JSESSIONID",sessionId)
		.body(PayLoad.jiraIssueBody())
		.post("rest/api/2/issue/");
		System.out.println(responseBody2);
		
	}

}
