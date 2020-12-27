package com.rahulshetty.jsonpath;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {

		// 1. Print No of courses returned by API
		// 2.Print Purchase Amount
		// 3. Print Title of the first course
		// 4. Print All course titles and their respective Prices
		// 5. Print no of copies sold by RPA Course
		// 6. Verify if Sum of all Course prices matches with Purchase Amount

		/**
		    {
  "dashboard": {
    "purchaseAmount": 910,
    "website": "rahulshettyacademy.com"
  },
  "courses": [
    {
      "title": "Selenium Python",
      "price": 50,
      "copies": 6
    },
    {
      "title": "Cypress",
      "price": 40,
      "copies": 4
    },
    {
      "title": "RPA",
      "price": 45,
      "copies": 10
    }
  ]
}
		 */

		String payLoad = "{\r\n" + "  \"dashboard\": {\r\n" + "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n" + "  },\r\n" + "  \"courses\": [\r\n" + "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n" + "      \"price\": 50,\r\n" + "      \"copies\": 6\r\n"
				+ "    },\r\n" + "    {\r\n" + "      \"title\": \"Cypress\",\r\n" + "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n" + "    },\r\n" + "    {\r\n" + "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n" + "      \"copies\": 10\r\n" + "    }\r\n" + "  ]\r\n" + "}";
		
		
		JsonPath js = new JsonPath(payLoad);
		// 1. Print No of courses returned by API
		int courses = js.getInt("courses.size()");
		System.out.println("No of courses returned by API: "+courses);
		
		// 2.Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount: "+purchaseAmount);
		
		// 3. Print Title of the first course
		
		String firstCourse = js.get("courses[0].title");
		System.out.println("Title of the first course: "+ firstCourse);
		
		// 4. Print All course titles and their respective Prices
		
		
		for(int i = 0; i<courses; i++)
		{
			String course = js.get("courses["+i+"].title");
			int price = js.getInt("courses["+i+"].price");
			System.out.println(course+"   "+price);
		}
		
		
		// 5. Print no of copies sold by RPA Course
		 
		
		for(int i = 0; i<courses; i++)
		{
			String course = js.get("courses["+i+"].title");
			if(course.equalsIgnoreCase("RPA"))
			{
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("No of copies sold by RPA Course:"+copies);
				break;
			}
		}
		
		
		// 6. Verify if Sum of all Course prices matches with Purchase Amount
		
		
		int init = 0;
		int totalAmout = 0;
		while(init < courses)
		{
			
			int price = js.getInt("courses["+init+"].price");
			int copies = js.getInt("courses["+init+"].copies");
			int totalPrice = price*copies;
			totalAmout+=totalPrice;
			
			init++;
		}
		
		System.out.println(totalAmout);
		Assert.assertEquals(totalAmout, purchaseAmount);
		
		
		

	}

}
