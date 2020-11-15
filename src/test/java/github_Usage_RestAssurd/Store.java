package github_Usage_RestAssurd;


import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.*;
import static org.hamcrest.Matchers.*;

public class Store {
	
	@Test
	public void store()
	{
		
		baseURI = "http://localhost:3000";
		
		// Get the response body as a String
		String response = get("/store").asString();
		// And get all books with price < 10 from the response. "from" is statically imported from the JsonPath class
		List<String> bookTitles = from(response).getList("book.findAll { it.price < 10 }.title");
		System.out.println(bookTitles);
	
		
		when().
	       get("/store").
	       then().
	       body("book.findAll { it.price < 10 }.title", hasItems("Sayings of the Century", "Moby Dick"));
		
		
	}

}
