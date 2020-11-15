package github_Usage_RestAssurd;

import org.testng.annotations.Test;

//import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static io.restassured.config.JsonConfig.*;


import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;



public class BiggDecimal3 {

	@Test
	public void decimal()
	{
		baseURI = "http://localhost:3000";
		
		given().
        config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
        when().
        get("/priceAll").
        then().
        body("price", is(new BigDecimal(12.12)));
	}

}
