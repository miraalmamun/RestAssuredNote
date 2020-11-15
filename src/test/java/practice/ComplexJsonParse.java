package practice;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import payload.PayLoad;

public class ComplexJsonParse {

	public static void main(String[] args) {

		
		
		
		JsonPath jsParse = new JsonPath(PayLoad.cousePrice());
		// Print No of courses returned by API

		int courseCount = jsParse.getInt("courses.size()");
		System.out.println("No of courses returned by API: " + courseCount);
		// Print Purchase Amount
		// dashboard.purchaseAmount---->Triverse parent to child

		int totalAmount = jsParse.getInt("dashboard.purchaseAmount");
		System.out.println("Total amount is: " + totalAmount);

		// Print Title of the first course

		String firstTitle = jsParse.get("courses[0].title");
		System.out.println("First course: " + firstTitle);

		// Print All course titles and their respective Prices
		for (int i = 0; i < courseCount; i++) {
			String path = jsParse.get("courses[" + i + "].title");
			int price = jsParse.getInt("courses[" + i + "].price");

			System.out.println(path + "  " + price);
		}

		// Print no of copies sold by RPA Course

		for (int i = 0; i < courseCount; i++) {
			String path = jsParse.get("courses[" + i + "].title");

			if (path.equalsIgnoreCase("RPA")) {
				// copies
				System.out.println("RPA copies sold: " + jsParse.getInt("courses[" + i + "].copies"));

				break;
			}

		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		
		int purchaseAmount = jsParse.getInt("dashboard.purchaseAmount");
		
		System.out.println("Purchase amount: "+purchaseAmount);
		
		int totalPrice = 0;
		
		for(int i = 0; i<courseCount; i++)
		{
			int price = jsParse.getInt("courses["+i+"].price");
			int copies = jsParse.getInt("courses["+i+"].copies");
			
			int price2 = price*copies;
			
			totalPrice+=price2;
		}
		
		System.out.println("Total price: "+totalPrice);
		
		
		Assert.assertEquals(totalPrice, purchaseAmount);
		
		
		
		
		
		
		
		
		
		/*

		System.out.println("======================================");

		JsonPath jsParse2 = new JsonPath(PayLoad.testData());
		System.out.println("No of test data set: " + jsParse2.getInt("testdata.size()"));

		String firstTestName = jsParse2.get("testdata[0].testName");
		System.out.println("First test case name: " + firstTestName);

		String data = jsParse2.get("testdata[0].data[0].runmode");
		System.out.println(data);
		String data2 = jsParse2.get("testdata[2].data[1].maxcost");
		System.out.println(data2);

		*/
		
		
		
	}

}
