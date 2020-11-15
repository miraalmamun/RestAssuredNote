package github_Usage_RestAssurd;

import java.io.FileReader;
import java.net.URI;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.get;

public class JsonExample1 {
	
	
	@Test
	public void t() throws Exception
	{
		
        String permissionsUrl = "";
		
		URI permissionsUri = new URI(permissionsUrl);
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader("\\db\\seed\\permission.json"));
		JSONArray expectedJson = (JSONArray) obj;
		String expectedStatus = "success";
		
		get(permissionsUri).then().assertThat().body("status", equalTo(expectedStatus)).and().body("body", equalTo(expectedJson));
		
		
		
		
		
		
		
		
		
	}

}
