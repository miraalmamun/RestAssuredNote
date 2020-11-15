package github_Usage_RestAssurd;

import org.testng.annotations.Test;

//import io.restassured.config.JsonConfig;
//import io.restassured.config.RestAssuredConfig;
//import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;

import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;

//import static io.restassured.config.JsonConfig.*;
//import static io.restassured.path.json.config.JsonPathConfig.*;

//import static org.hamcrest.Matchers.*;

//import java.math.BigDecimal;
import java.util.ArrayList;

//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static io.restassured.module.jsv.JsonSchemaValidator.*;
//import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

public class BiggDecimal {

	@Test
	public void decimal()
	{
		baseURI = "http://localhost:3000";
		//get("/price").then().body("price", is(12.12f));
		
		//RestAssured.given().log().all().contentType(ContentType.JSON)
		//.when().get("/priceAll").then().assertThat().body("price", is(12.12f));
	
		//given().config(config().jsonConfig(jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL)));
		
		//given().contentType(ContentType.JSON).config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL)))
       // .when().
      //  get("/priceAll").
      //  then().
      // body("price", is(new BigDecimal(12.12)));
		
		
		
		ArrayList<Float> f = given().contentType(ContentType.JSON).get("/priceAll").then().extract().path("price");
		ArrayList<Double> d = given().contentType(ContentType.JSON).get("/priceAll").then().extract().path("price");
		
		System.out.println(f.get(0));
		System.out.println(d.get(0));
		
		
		
		
		
		
		
		
		
		
		
        
	}

}
