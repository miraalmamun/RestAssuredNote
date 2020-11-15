package github_Usage_RestAssurd;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
	

public class SchemaValidation {
	
	
	@Test
	public void schema()
	{
		baseURI = "http://localhost:3000";
		
		get("/products").then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
		
		
	}

}
