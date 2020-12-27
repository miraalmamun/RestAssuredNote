package https.reqres.in;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo2.AllCourses;

public class AllCoursesTest2 {

	public static void main(String[] args) throws Exception {
		
		ObjectMapper objMapper = new ObjectMapper();
		//String convertedJson=objMapper.writeValueAsString(AllCourses.getCourse());
		//System.out.println(convertedJson);
		
		
		String userDir=System.getProperty("user.dir");
		File outputJsonFile=new File(userDir+"/payLoad.json");
		
		objMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, AllCourses.getCourse());
		
		
		/*
		 Response postResponse = given().auth().none()
				 .contentType(ContentType.JSON)
					.body(convertedJson).log().all()
					.when().post("https://reqres.in/api/users");
		 
		 System.out.println("Post Response is: "+postResponse.asString());
		 postResponse.prettyPrint();
       */
	}

}
