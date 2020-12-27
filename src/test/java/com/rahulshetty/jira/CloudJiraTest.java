package com.rahulshetty.jira;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CloudJiraTest {

	public static void main(String[] args) {

		 RestAssured.baseURI = "https://almamunmir.atlassian.net/rest/api/2/issue";
		 String encodedCredentialsAsString = "YWxtYW11bm1pcjc5QGdtYWlsLmNvbTpSQ3R1bTFFdUdVaFJrcWhZaVdHYTQwRTU=";
		 String cookie = "atlassian.xsrf.token=c5c58ce5-8418-4f62-8466-f8336bfaf040_db53fc001a25b5b7be0bb1bc08919c1b324a2174_lin";
			
	        RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation().urlEncodingEnabled(false)
	        		.header("Authorization","Basic "+encodedCredentialsAsString)
                    .header("Cookie ",cookie)
			.header("Content-Type", "application/json");
			
			Response response = rs.when().get("/DEAL2-2");
			
			ValidatableResponse vr = response.then().assertThat()
			.statusCode(200);
		   
			System.out.println(vr.extract().response().getTime());
			
           response.prettyPrint();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		
// TODO Auto-generated method stub

		RestAssured.baseURI = "http://localhost:8080";

//Login Scenario

		SessionFilter session = new SessionFilter();

		@SuppressWarnings("unused")
		String response = given().relaxedHTTPSValidation().header("Content-Type", "application/json").body("{\r\n" +

				"    \"username\": \"mirmirmir12547\",\r\n" +

				"    \"password\": \"XXXX11\"\r\n" +

				"}").log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract()
				.response().asString();

		String expectedMessage = "Hi How are you?";

//Add comment

		String addCommentResponse = given().pathParam("key", "10101").log().all()
				.header("Content-Type", "application/json").body("{\r\n" +

						"    \"body\": \"" + expectedMessage + "\",\r\n" +

						"    \"visibility\": {\r\n" +

						"        \"type\": \"role\",\r\n" +

						"        \"value\": \"Administrators\"\r\n" +

						"    }\r\n" +

						"}")
				.filter(session).when().post("/rest/api/2/issue/{key}/comment").then().log().all()

				.assertThat().statusCode(201).extract().response().asString();

		JsonPath js = new JsonPath(addCommentResponse);

		String commentId = js.getString("id");

//Add Attachment

		given().header("X-Atlassian-Token", "no-check").filter(session).pathParam("key", "10101")

				.header("Content-Type", "multipart/form-data")

				.multiPart("file", new File("jira.txt")).when().

				post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);

//Get Issue

		String issueDetails = given().filter(session).pathParam("key", "10101")

				.queryParam("fields", "comment")

				.log().all().when().get("/rest/api/2/issue/{key}").then()

				.log().all().extract().response().asString();

		System.out.println(issueDetails);

		JsonPath js1 = new JsonPath(issueDetails);

		int commentsCount = js1.getInt("fields.comment.comments.size()");

		for (int i = 0; i < commentsCount; i++)

		{

			String commentIdIssue = js1.get("fields.comment.comments[" + i + "].id").toString();

			if (commentIdIssue.equalsIgnoreCase(commentId))

			{

				String message = js1.get("fields.comment.comments[" + i + "].body").toString();

				System.out.println(message);

				Assert.assertEquals(message, expectedMessage);

			}

		}

	*/}

}
