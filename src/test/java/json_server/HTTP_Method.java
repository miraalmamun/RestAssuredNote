package json_server;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class HTTP_Method {

	@Test
	public void getMethod() {
		baseURI = "http://localhost:3000";

		
		get("/lotto").then().body("winners.winnerId", hasItems(23, 54));
		get("/lotto").then().body("lottoId", equalTo(5));
		
		
	}

}
