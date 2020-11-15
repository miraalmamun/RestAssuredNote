package libraryAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import payload.PayLoad;
import random.RandomGen;

public class Library3 {

	@Test(dataProvider = "data")
	public void addRetrieveBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";

		RequestSpecification rs = RestAssured.given().header("Content-Type", "application/json")
				.body(PayLoad.addBook(isbn, aisle));
		Response response = rs.when().post("/Library/Addbook.php");
		ValidatableResponse vr = response.then().assertThat().statusCode(200);
		String responseBody = vr.extract().response().asString();
		//System.out.println("==========" + responseBody);

		JsonPath jsonPath = new JsonPath(responseBody);
		String id = jsonPath.get("ID");
		System.out.println("Id: " + id);

	}
	
	
	
	@DataProvider(name = "data")
	public Object[][] getData()
	{
		
		
		return new Object[][] {{RandomGen.randomString(3),RandomGen.randomString2(3)},
			{RandomGen.randomString(3),RandomGen.randomString2(3)},
			{RandomGen.randomString(3),RandomGen.randomString2(3)}};
		 
	}

	
	
	
	
	
	
	
	
	
	
}
