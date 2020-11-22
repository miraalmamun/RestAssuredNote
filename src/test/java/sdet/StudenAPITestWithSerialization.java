package sdet;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudenAPITestWithSerialization {
	
	
	@Test(priority = 1,enabled = true)
	public void createNewStudenSerialization()
	{
		
		List<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		Student2 stu = new Student2();
		stu.setId(102);
		stu.setFirstName("Mir1");
		stu.setLastName("Mamun1");
		stu.setEmail("abc1@gmail.com");
		stu.setProgramme("Manager");
		stu.setCourses(coursesList);
		
		RequestSpecification httpRequest =RestAssured.given().log().all();
		httpRequest.contentType(ContentType.JSON)
		.body(stu)
		.when().post("http://localhost:8085/student")
		.then().log().all().assertThat().statusCode(201)
		.body("msg",equalTo("Student added") );
	}
	@Test(priority = 2,enabled = true)
	void getStudentRecordedDeserialization()
	{
		Student2 stu = get("http://localhost:8085/student/102").as(Student2.class);
		System.out.println(stu.getStudentRecord());
		System.out.println(stu.getId());
		Assert.assertEquals(stu.getId(), new Integer(102));
	}
	
	
	
	
	

}
