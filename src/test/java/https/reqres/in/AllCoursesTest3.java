package https.reqres.in;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo2.AllCourses;
import pojo2.GetCourse;

import static io.restassured.RestAssured.*;
public class AllCoursesTest3 {

	public static void main(String[] args) throws Exception {
		
		ObjectMapper objMapper = new ObjectMapper();
		String convertedJson = objMapper.writeValueAsString(AllCourses.getCourse());
		System.out.println("Converted Json is: "+convertedJson);
		
	
		 Response postResponse = given().auth().none()
				 .contentType(ContentType.JSON)
					.body(convertedJson).log().all()
					.when().post("https://reqres.in/api/users");
		 
		 
		 String response = postResponse.asString();
		 
		 objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		 
		 GetCourse readValue = objMapper.readValue(response, GetCourse.class);
		 String instructor = readValue.getInstructor();
		 System.out.println("Instructor: "+instructor);
		 
		 System.out.println("Post Response is: "+postResponse.asString());
		 postResponse.prettyPrint();
      
	}

}
