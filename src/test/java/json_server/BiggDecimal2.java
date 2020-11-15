package json_server;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

//import io.restassured.config.JsonConfig;
//import io.restassured.config.RestAssuredConfig;
//import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.testng.annotations.Test;

public class BiggDecimal2 {

	@Test
	public void decimal() {
		
		
		
		//equalTo(Arrays.asList("got it"));
		
		baseURI = "http://localhost:3000";
		//get("/priceAll").then().body("price", is(12.12f));
		get("/priceAll").then().body("price", is(Arrays.asList(12.12f)));
		get("/priceAll").then().body("price", equalTo(Arrays.asList(12.12f)));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		String s = get("/priceAll").then().extract().response().asString();
		System.out.println(s);
		Response rs = get("/priceAll");
		JsonPath p = rs.jsonPath();
		
		ArrayList<Double> d = p.get("price");
		System.out.println(d);
		*/
		//System.out.println(p.getLong("price"));
		//System.out.println(p.getFloat("price"));
		//System.out.println(p.getDouble("price"));
		//System.out.println(p.getInt("price"));
		
	}

}
