package practice;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StartRest5_2 {
	@Test
	public void play() throws Exception {

		

		String path = System.getProperty("user.dir") + "\\JSONFiles\\addPlace.json";
		System.out.println(path);
		//Content of file convert into Byte then Byte data into String data
		byte[] b = Files.readAllBytes(Paths.get(path));
		System.out.println("File convert into byte array "+b);
		String s = new String(b);
		System.out.println("byte array into String "+s);
		System.out.println("=========================================================================== ");
		
		byte[] by = {123, 13, 10, 9, 34, 108, 111, 99, 97, 116, 105, 111, 110, 34, 58, 32, 123, 13, 10, 9, 9, 34, 108, 97, 116, 34, 58, 32, 45, 51, 56, 46, 51, 56, 51, 52, 57, 52, 44, 13, 10, 9, 9, 34, 108, 110, 103, 34, 58, 32, 51, 51, 46, 52, 50, 55, 51, 54, 50, 13, 10, 9, 125, 44, 13, 10, 9, 34, 97, 99, 99, 117, 114, 97, 99, 121, 34, 58, 32, 53, 48, 44, 13, 10, 9, 34, 110, 97, 109, 101, 34, 58, 32, 34, 70, 114, 111, 110, 116, 108, 105, 110, 101, 32, 104, 111, 117, 115, 101, 34, 44, 13, 10, 9, 34, 112, 104, 111, 110, 101, 95, 110, 117, 109, 98, 101, 114, 34, 58, 32, 34, 40, 43, 57, 49, 41, 32, 57, 56, 51, 32, 56, 57, 51, 32, 51, 57, 51, 55, 34, 44, 13, 10, 9, 34, 97, 100, 100, 114, 101, 115, 115, 34, 58, 32, 34, 50, 57, 44, 32, 115, 105, 100, 101, 32, 108, 97, 121, 111, 117, 116, 44, 32, 99, 111, 104, 101, 110, 32, 48, 57, 34, 44, 13, 10, 9, 34, 116, 121, 112, 101, 115, 34, 58, 32, 91, 13, 10, 9, 9, 34, 115, 104, 111, 101, 32, 112, 97, 114, 107, 34, 44, 13, 10, 9, 9, 34, 115, 104, 111, 112, 34, 13, 10, 9, 93, 44, 13, 10, 9, 34, 119, 101, 98, 115, 105, 116, 101, 34, 58, 32, 34, 104, 116, 116, 112, 58, 47, 47, 103, 111, 111, 103, 108, 101, 46, 99, 111, 109, 34, 44, 13, 10, 9, 34, 108, 97, 110, 103, 117, 97, 103, 101, 34, 58, 32, 34, 70, 114, 101, 110, 99, 104, 45, 73, 78, 34, 13, 10, 125, 13, 10};
		String by2 = new String(by);
		System.out.println("Byte convert into String: "+by2);
		
		//123, 13, 10, 9, 34, 108, 111, 99, 97, 116, 105, 111, 110, 34, 58, 32, 123, 13, 10, 9, 9, 34, 
		//108, 97, 116, 34, 58, 32, 45, 51, 56, 46, 51, 56, 51, 52, 57, 52, 44, 13, 10, 9, 9, 34, 108, 
		//110, 103, 34, 58, 32, 51, 51, 46, 52, 50, 55, 51, 54, 50, 13, 10, 9, 125, 44, 13, 10, 9, 34, 
		//97, 99, 99, 117, 114, 97, 99, 121, 34, 58, 32, 53, 48, 44, 13, 10, 9, 34, 110, 97, 109, 101,
		//34, 58, 32, 34, 70, 114, 111, 110, 116, 108, 105, 110, 101, 32, 104, 111, 117, 115, 101, 34, 
		//44, 13, 10, 9, 34, 112, 104, 111, 110, 101, 95, 110, 117, 109, 98, 101, 114, 34, 58, 32, 34, 
		//40, 43, 57, 49, 41, 32, 57, 56, 51, 32, 56, 57, 51, 32, 51, 57, 51, 55, 34, 44, 13, 10, 9, 34,
		//97, 100, 100, 114, 101, 115, 115, 34, 58, 32, 34, 50, 57, 44, 32, 115, 105, 100, 101, 32, 108,
		//97, 121, 111, 117, 116, 44, 32, 99, 111, 104, 101, 110, 32, 48, 57, 34, 44, 13, 10, 9, 34, 116, 
		//121, 112, 101, 115, 34, 58, 32, 91, 13, 10, 9, 9, 34, 115, 104, 111, 101, 32, 112, 97, 114, 107,
		//34, 44, 13, 10, 9, 9, 34, 115, 104, 111, 112, 34, 13, 10, 9, 93, 44, 13, 10, 9, 34, 119, 101, 98, 
		//115, 105, 116, 101, 34, 58, 32, 34, 104, 116, 116, 112, 58, 47, 47, 103, 111, 111, 103, 108, 101, 
		//46, 99, 111, 109, 34, 44, 13, 10, 9, 34, 108, 97, 110, 103, 117, 97, 103, 101, 34, 58, 32, 34, 70, 
		//114, 101, 110, 99, 104, 45, 73, 78, 34, 13, 10, 125, 13, 10]
		

		
		
		System.out.println("====================================================================================");
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Files.readAllBytes(Paths.get(path))).when().post("maps/api/place/add/json").then().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract()
				.response().asString();
		System.out.println(response);
      
	}

}
