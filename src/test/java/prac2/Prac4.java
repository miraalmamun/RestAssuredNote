package prac2;

import io.restassured.path.json.JsonPath;

public class Prac4 {
	
	static String payLoad = "  {\r\n" + 
			"  \"dashboard\": {\r\n" + 
			"    \"purchaseAmount\": 910,\r\n" + 
			"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
			"  },\r\n" + 
			"  \"courses\": [\r\n" + 
			"    {\r\n" + 
			"      \"title\": \"Selenium Python\",\r\n" + 
			"      \"price\": 50,\r\n" + 
			"      \"copies\": 6\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"title\": \"Cypress\",\r\n" + 
			"      \"price\": 40,\r\n" + 
			"      \"copies\": 4\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"title\": \"RPA\",\r\n" + 
			"      \"price\": 45,\r\n" + 
			"      \"copies\": 10\r\n" + 
			"    }\r\n" + 
			"  ]\r\n" + 
			"}";

	public static void main(String[] args) {
		
		
		   JsonPath path = new JsonPath(payLoad);
		   int RPApRICE =  path.getInt("courses[2].price");
		   System.out.println(RPApRICE);
		   
		  // JSONObject obj = new JSONObject();
		   
		
		

	}
}


























