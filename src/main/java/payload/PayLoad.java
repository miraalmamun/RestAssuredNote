package payload;

public class PayLoad {

	
	public static String addBookLibrary(String isbn,String aisle)
	{
		
		String add = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"MirJava2\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"MirChan\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"";
		
		return add;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String addPlace() {
		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Dream\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"Please help me Allah\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"https://mydream.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";
	}
	
	
	
	public static String updatePlace(String placeId, String newAddress)
	{
		
		
		return "{\r\n" + 
	     		"\"place_id\":\""+placeId+"\",\r\n" + 
	     		"\"address\":\""+newAddress+"\",\r\n" + 
	     		"\"key\":\"qaclick123\"\r\n" + 
	     		"}\r\n" + 
	     		"";
	}
	
	
	
	public static String updateBody(String id)
	{
		return "{\r\n" + 
				"  \"place_id\": \""+id+"\",\r\n" + 
				"  \"address\": \"Bangladesh,Bera,Pabna, USA\",\r\n" + 
				"  \"language\": \"Bangla\",\r\n" + 
				"  \"key\": \"qaclick123\"\r\n" + 
				"}";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String cousePrice()
	{
		return "{\r\n" + 
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
	}
	
	
	
	
	
	public static String testData()
	{
		String data = "{\r\n" + 
				"	\"testdata\": [\r\n" + 
				"		{\r\n" + 
				"			\"testName\": \"LoginTest\",\r\n" + 
				"			\"data\": [\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"y\",\r\n" + 
				"					\"browser\": \"chrome\",\r\n" + 
				"					\"username\": \"abc@gmail.com\",\r\n" + 
				"					\"password\": \"pass1234\"\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"n\",\r\n" + 
				"					\"browser\": \"mozilla\",\r\n" + 
				"					\"username\": \"abc@gmail.com\",\r\n" + 
				"					\"password\": \"pass1234\"\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"y\",\r\n" + 
				"					\"browser\": \"edge\",\r\n" + 
				"					\"username\": \"abc@gmail.com\",\r\n" + 
				"					\"password\": \"pass1234\"\r\n" + 
				"				}\r\n" + 
				"			]\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"data\": [\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"y\",\r\n" + 
				"					\"browser\": \"chrome\",\r\n" + 
				"					\"productname\": \"iphone1 10\",\r\n" + 
				"					\"mincost\": \"10000\",\r\n" + 
				"					\"maxcost\": \"50000\"\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"y\",\r\n" + 
				"					\"browser\": \"mozilla\",\r\n" + 
				"					\"productname\": \"IBM ThinkPad\",\r\n" + 
				"					\"mincost\": \"50000\",\r\n" + 
				"					\"maxcost\": \"100000\"\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"n\",\r\n" + 
				"					\"browser\": \"edge\",\r\n" + 
				"					\"productname\": \"Iball Headphones\",\r\n" + 
				"					\"mincost\": \"1000\",\r\n" + 
				"					\"maxcost\": \"5000\"\r\n" + 
				"				}\r\n" + 
				"			],\r\n" + 
				"			\"testName\": \"PurchaseProductTest\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"data\": [\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"y\",\r\n" + 
				"					\"browser\": \"chrome\",\r\n" + 
				"					\"productname\": \"iphone 10\",\r\n" + 
				"					\"operation\": \"remove\"\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"runmode\": \"y\",\r\n" + 
				"					\"browser\": \"mozilla\",\r\n" + 
				"					\"productname\": \"IBM ThinkPad\",\r\n" + 
				"					\"mincost\": \"50000\",\r\n" + 
				"					\"maxcost\": \"100000\"\r\n" + 
				"				}\r\n" + 
				"			],\r\n" + 
				"			\"testName\": \"ProductOperationTest\"\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}\r\n" + 
				"";
		
		return data;
	}
	
	
	
	
	
	
	public static String addBook(String isbn, String aisle)
	{
		String add = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Mir Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"";
		return add;
	}
	
	
	public  static String jiraIssueBody()
	{
		return "{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"BAN\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
				"        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
	}
	
	
	
	
	
}

