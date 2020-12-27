package https.reqres.in;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo2.AllCourses;

public class AllCoursesTest {

	public static void main(String[] args) {
		
		
		 Response postResponse = given().auth().none()
				 .contentType(ContentType.JSON)
					.body(AllCourses.getCourse()).log().all()
					.when().post("https://reqres.in/api/users");
		 
		 System.out.println("Post Response is: "+postResponse.asString());
		 postResponse.prettyPrint();

	}

}
