package libraryAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import payload.PayLoad;
import random.RandomPractice;

public class Library {
	
	
	String isbn = RandomPractice.getRandonStringLower(4);
	String aisle = RandomPractice.getNumberString(3);
	
	
	
	
	@Test
	public void addRetrieveBook()
	{
		//http://216.10.245.166/Library/Addbook.php
		RestAssured.baseURI = "http://216.10.245.166";
		
		RequestSpecification rs = RestAssured.given().log().all().header("Content-Type","application/json")
		.body(PayLoad.addBookLibrary(isbn, aisle));
		Response response = rs.when().post("/Library/Addbook.php");
		ValidatableResponse vr = response.then().log().all().assertThat().statusCode(200);
		String responseBody = vr.extract().response().asString();
		System.out.println("=========="+responseBody);
		
		JsonPath jsonPath = new JsonPath(responseBody);
		String id = jsonPath.get("ID");
		System.out.println("Id: "+id);
		
		
		
		
	}
	
	@Test
	public void addRetrieveBook2() throws Exception
	{
		/*
		//http://216.10.245.166/Library/Addbook.php
		String path = System.getProperty("user.dir")+"\\JSONFiles\\addBook.json";
		RestAssured.baseURI = "http://216.10.245.166";
		
		RequestSpecification rs = RestAssured.given().log().all().header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get(path))));
		Response response = rs.when().post("/Library/Addbook.php");
		ValidatableResponse vr = response.then().log().all().assertThat().statusCode(200);
		String responseBody = vr.extract().response().asString();
		System.out.println("=========="+responseBody);
		
		JsonPath jsonPath = new JsonPath(responseBody);
		String id = jsonPath.get("ID");
		System.out.println("Id: "+id);
		
		*/
		
		
	}
	
	
	
	
	
	
	

}
