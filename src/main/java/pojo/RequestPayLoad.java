package pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestPayLoad {

	public static void main(String[] args) throws Exception {

		Api api = new Api();
		api.setCourseTitle("Rest Assured Automation using Java");
		api.setPrice("50");
		
		ObjectMapper mapper2 = new ObjectMapper();
		String st2 = mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(api);
        System.out.println(st2);
        
		Api api2 = new Api();
		api2.setCourseTitle("SoapUI Webservices testing");
		api2.setPrice("50");
		
		

		List<Api> list = new ArrayList<Api>();
		list.add(api);
		list.add(api2);
		
		ObjectMapper mapper3 = new ObjectMapper();
		String st3 = mapper3.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		 System.out.println(st3);

		Mobile mobile = new Mobile();
		mobile.setCourseTitle("Appium-Mobile Automation using Java");
		mobile.setPrice("50");
		List<Mobile> list2 = new ArrayList<Mobile>();
		list2.add(mobile);

		WebAutomation auto = new WebAutomation();
		auto.setCourseTitle("Selenium Webdriver Java");
		auto.setPrice("50");

		WebAutomation auto2 = new WebAutomation();
		auto2.setCourseTitle("Cypress");
		auto2.setPrice("40");

		WebAutomation auto3 = new WebAutomation();
		auto3.setCourseTitle("Protractor");
		auto3.setPrice("40");

		List<WebAutomation> list3 = new ArrayList<WebAutomation>();
		list3.add(auto);
		list3.add(auto2);
		list3.add(auto3);
		
		Courses crs = new Courses();
		crs.setApi(list);
		crs.setMobile(list2);
		crs.setWebAutomation(list3);
		
		GetCourse getcrs = new GetCourse();
		getcrs.setCourses(crs);
		getcrs.setExpertise("Automation");
		getcrs.setInstructor("RahulShetty");
		getcrs.setLinkedIn("https://www.linkedin.com/in/rahul-shetty-trainer/");
		getcrs.setServices("projectSupport");
		getcrs.setUrl("rahulshettycademy.com");
		
		System.out.println(getcrs.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		String st = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getcrs);
		
		System.out.println(st);

	}

}
