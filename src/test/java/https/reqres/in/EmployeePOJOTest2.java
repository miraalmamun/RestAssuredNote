package https.reqres.in;

import static io.restassured.RestAssured.given;

import java.util.Arrays;

import org.testng.Assert;

import https.reqres.in.POJO.EmployeePOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeePOJOTest2 {

	public static void main(String[] args) {
		
		EmployeePOJO test = new EmployeePOJO("Mir", "QA", Arrays.asList("Java","C"), "ABC", "mbv@gmail.com");
		System.out.println(test);
		
		 Response post = given().auth().none().contentType(ContentType.JSON)
					.body(test).log().all().when().post("https://reqres.in/api/users");
	
					System.out.println("Response Body Below===== ");
					post.prettyPrint();
					
					Assert.assertEquals(post.getBody().path("name"), "Mir");
					Assert.assertEquals(post.getBody().path("skills[0]"), "Java");
					Assert.assertEquals(post.getBody().path("details.companyName"), "ABC");
					
					
					
					/*
		{
    {
    "name": "Mir",
    "job": "QA",
    "skills": [
        "Java",     //This is request body
        "C"
    ],
    "details": {
        "companyName": "ABC",
        "emailId": "mbv@gmail.com"
    }
}
*/
		
					/*
					 * 
					 * 
					 * {
    "name": "Mir",
    "job": "QA",
    "skills": [
        "Java",
        "C"
    ],                           //This is response body
    "details": {
        "companyName": "ABC",
        "emailId": "mbv@gmail.com"
    },
    "id": "754",
    "createdAt": "2020-12-27T03:12:43.586Z"
}
					 */

	}}
