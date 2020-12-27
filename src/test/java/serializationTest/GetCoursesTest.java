package serializationTest;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import serialization.Api;

public class GetCoursesTest {
	
	@Test
	public void getSerialization() throws Exception
	{
		//GetCourses gc = new GetCourses(instructor, url, services, expertise, courses, linkedIn)
		
		Api api = new Api("Rest Assured Automation using Java", 50);
		
		ObjectMapper map = new ObjectMapper();
		String writeValueAsString = map.writerWithDefaultPrettyPrinter().writeValueAsString(api);
		System.out.println(writeValueAsString);
	}

}
