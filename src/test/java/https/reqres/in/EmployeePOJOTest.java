package https.reqres.in;

import static io.restassured.RestAssured.given;

import java.util.Arrays;

import https.reqres.in.POJO.EmployeePOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeePOJOTest {

	public static void main(String[] args) {
		
		EmployeePOJO test = new EmployeePOJO("Mir", "QA", Arrays.asList("Java","C"), "ABC", "mbv@gmail.com");
		System.out.println(test);
		
		 Response post = given().auth().none().contentType(ContentType.JSON)
					.body(test).log().all().when().post("https://reqres.in/api/users");
		 
		 
		 System.out.println("========================getBody().path()=================");
		 System.out.println();
		
		             System.out.println("Name is: "+post.getBody().path("name"));
		             System.out.println("job is: "+post.getBody().path("job"));
		             System.out.println("First skills is: "+post.getBody().path("name"));
		             System.out.println("Name is: "+post.getBody().path("skills[0]"));
		             System.out.println("Name is: "+post.getBody().path("skills[1]"));
		             System.out.println("Company Name is: "+post.getBody().path("details.companyName"));
		             System.out.println("Email is: "+post.getBody().path("details.emailId"));
		             System.out.println("Id is: "+post.getBody().path("id"));
		             System.out.println("CreatedAt is: "+post.getBody().path("createdAt"));
		             
		             System.out.println();
		             System.out.println("========================jsonPath().get()================="); 
		             System.out.println();
		             
		             
		             System.out.println("Name is: "+post.jsonPath().get("name"));
		             System.out.println("job is: "+post.jsonPath().get("job"));
		             System.out.println("First skills is: "+post.jsonPath().get("name"));
		             System.out.println("Name is: "+post.jsonPath().get("skills[0]"));
		             System.out.println("Name is: "+post.jsonPath().get("skills[1]"));
		             System.out.println("Company Name is: "+post.jsonPath().get("details.companyName"));
		             System.out.println("Email is: "+post.jsonPath().get("details.emailId"));
		             System.out.println("Id is: "+post.jsonPath().get("id"));
		             System.out.println("CreatedAt is: "+post.jsonPath().get("createdAt"));
		             
		             
		             
		             
		             
		             
		 
					System.out.println();
					System.out.println();
					System.out.println(post.getStatusCode());
					System.out.println(post.getTime());
					System.out.println();
					System.out.println("======================");
					System.out.println("Response Body Below===== ");
					post.prettyPrint();
					
					
					
					
					
					/*{
    "name": "Mamun",
    "job": "leader",
    "skills": [
        "Java",
        "C"
    ],
    "details": {
        "companyName": "XYZ",
        "emailId": "msaq@gmail.com"
    }
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
    ],
    "details": {
        "companyName": "ABC",
        "emailId": "mbv@gmail.com"
    },
    "id": "754",
    "createdAt": "2020-12-27T03:12:43.586Z"
}
					 */

	}}
