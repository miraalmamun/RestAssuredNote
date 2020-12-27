package prac2;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Prac5 {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://almamunmir.atlassian.net/rest/api/2/issue/DEAL2-2";
		String encodedCredentialsAsString = "YWxtYW11bm1pcjc5QGdtYWlsLmNvbTpSQ3R1bTFFdUdVaFJrcWhZaVdHYTQwRTU=";
		String cookie = "atlassian.xsrf.token=c5c58ce5-8418-4f62-8466-f8336bfaf040_db53fc001a25b5b7be0bb1bc08919c1b324a2174_lin";

		RequestSpecification rs = RestAssured.given().relaxedHTTPSValidation().urlEncodingEnabled(false)
				.header("Authorization", "Basic " + encodedCredentialsAsString).header("Cookie ", cookie)
				.header("Content-Type", "application/json");

		Response response = rs.when().get();

		@SuppressWarnings("unused")
		ValidatableResponse vr = response.then().assertThat().statusCode(200);

		response.prettyPrint();

		// ============================================================================

		RestAssured.baseURI = "https://almamunmir.atlassian.net";

		String expectedMessage = "Hi I am using Rest Assured to add third comment?";

		String addCommentResponse = RestAssured.given().log().all().relaxedHTTPSValidation().urlEncodingEnabled(false)
				.header("Authorization", "Basic " + encodedCredentialsAsString).header("Cookie ", cookie)
				.pathParam("key", "10020").header("Content-Type", "application/json")
				.body("{\r\n" + "    \"body\": \"" + expectedMessage + "\"\r\n" + "}")
				.post("/rest/api/2/issue/{key}/comment").then().log().all()

				.assertThat().statusCode(201).extract().response().asString();

		JsonPath js = new JsonPath(addCommentResponse);

		String commentId = js.getString("id");
		System.out.println("===============================" + commentId);

		// Add Attachment

		given().relaxedHTTPSValidation().urlEncodingEnabled(false).header("X-Atlassian-Token", "no-check")
				.header("Authorization", "Basic " + encodedCredentialsAsString).header("Cookie ", cookie)
				.pathParam("key", "10020").header("Content-Type", "multipart/form-data")

				.multiPart("file", new File("jira.txt")).when().

				post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);

		// Get Issue

		String issueDetails = given().pathParam("key", "10020").relaxedHTTPSValidation().urlEncodingEnabled(false)
				.queryParam("fields", "comment").header("Authorization", "Basic " + encodedCredentialsAsString)
				.header("Cookie ", cookie).log().all().when().get("/rest/api/2/issue/{key}").then()

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

	}
}
