package toolsQA;

import static org.testng.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication {
	
	@Test(enabled = false)
	public void authenticateUserTest()
	{   
		//work very good
		
		RequestSpecification httpRequest;
		Response response;
		String encodedCredentialsAsString;
		
		RestAssured.baseURI = "https://bookstore.toolsqa.com/";
		String payLoad = "{\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\",\r\n" + 
				"  \"collectionOfIsbns\": [\r\n" + 
				"    {\r\n" + 
				"      \"isbn\": \"9781449331818\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
	     /**
	      * Authenticate user
	      */
		String credentials = "mimo5252:Mimo@949658";
		byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
		encodedCredentialsAsString = new String(encodedCredentials);
		
		httpRequest = RestAssured.given();
		httpRequest.header("Authorization","Basic "+encodedCredentialsAsString);
		httpRequest.contentType(ContentType.JSON);
		/**
		 * Add book for User
		 */
		
		response = httpRequest.body(payLoad).post("BookStore/v1/Books");
		System.out.println("Book add response code is: "+response.getStatusCode());
		response.prettyPrint();
		
		//============================Remove Book from user=====================
		
		String removeDetails = "{\r\n" + 
				"  \"isbn\": \"9781449331818\",\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\"\r\n" + 
				"}";
		
		httpRequest = RestAssured.given();
		httpRequest.header("Authorization","Basic "+encodedCredentialsAsString)
		.header("Content-Type","application/json");
		
		
		response = httpRequest.body(removeDetails).delete("BookStore/v1/Book");
		System.out.println("Book delete response code is: "+response.getStatusCode());
		String s = response.body().asString();
		System.out.println(s);
		response.prettyPrint();
		
		
		
		
	}
    
	@Test(enabled = false)
	public void bearerTokenAuthenticationTest()
	{   
		//Work very good
		
		RequestSpecification httpRequest;
		Response responseFromGenerateToken;
		String tokenGenerated;
		Response response;
		String jsonString;
		
		String payLoadBook = "{\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\",\r\n" + 
				"  \"collectionOfIsbns\": [\r\n" + 
				"    {\r\n" + 
				"      \"isbn\": \"9781449331818\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		//9781449365035
		String payLoadForToken = "{\r\n" + 
				"  \"userName\": \"mimo5252\",\r\n" + 
				"  \"password\": \"Mimo@949658\"\r\n" + 
				"}";
		String delete = "{\r\n" + 
				"  \"isbn\": \"9781449331818\",\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\"\r\n" + 
				"}";
		RestAssured.baseURI = "https://bookstore.toolsqa.com/";
		
		//=============================TokenGenerated==========================
		System.out.println("=============================TokenGenerated==========================");
		
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		responseFromGenerateToken = httpRequest.body(payLoadForToken).post("Account/v1/GenerateToken");
		responseFromGenerateToken.prettyPrint();
		
		jsonString = responseFromGenerateToken.getBody().asString();
		tokenGenerated = JsonPath.from(jsonString).get("token");
		
		//=======================Add book for user================================
		System.out.println("=======================Add book for user================================");
		
		httpRequest.header("Authorization","Bearer "+tokenGenerated)
		.header("Content-Type","application/json");
		
		response = httpRequest.body(payLoadBook).post("BookStore/v1/Books");
		assertEquals(201, response.getStatusCode());
		System.out.println("Book add response code is: "+response.getStatusCode());
		response.prettyPrint();
		
		//==============================Remove Book From User===========================
		System.out.println("============================================================");
		
		httpRequest = RestAssured.given().queryParam("UserId","bd18bf85-f718-4a82-8cf8-20a44af31ea8");
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("Authorization","Bearer "+tokenGenerated);
		
		
		response = httpRequest.body(delete).delete("BookStore/v1/Books");
		response.prettyPrint();
		System.out.println("Book delete response code is: "+response.getStatusCode());
		
		 	
	}
	
	@Test(enabled = false)
	public void userBooksDelete()
	{    
		
		//work very good
		String delete = "{\r\n" + 
				"  \"isbn\": \"9781449365035\",\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\"\r\n" + 
				"}";
		
		String payLoad = "{\r\n" + 
				"  \"userName\": \"mimo5252\",\r\n" + 
				"  \"password\": \"Mimo@949658\"\r\n" + 
				"}";
		RestAssured.baseURI = "https://bookstore.toolsqa.com/";
		
		RequestSpecification httpRequest = RestAssured.given().queryParam("UserId","bd18bf85-f718-4a82-8cf8-20a44af31ea8");
		httpRequest.header("Content-Type","application/json");
		Response responseFromGenerateToken = httpRequest.body(payLoad).post("Account/v1/GenerateToken");
		responseFromGenerateToken.prettyPrint();
		
		String jsonString = responseFromGenerateToken.getBody().asString();
		String tokenGenerated = JsonPath.from(jsonString).get("token");
		
		httpRequest.header("Authorization","Bearer "+tokenGenerated)
		.header("Content-Type","application/json");
		
		Response response = httpRequest.body(delete).delete("BookStore/v1/Books");
		response.prettyPrint();
		System.out.println("Remove book from user response code: "+response.getStatusCode());
	
		
	}
	//=============================================================================
	
	@Test(enabled = false)
	public void addBookandDeleteBookTest()
	{   
		
		//work very good
		
		
		RequestSpecification httpRequest;
		Response responseFromGenerateToken;
		String tokenGenerated;
		Response response;
		String jsonString;
		
		String addPayLoad = "{\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\",\r\n" + 
				"  \"collectionOfIsbns\": [\r\n" + 
				"    {\r\n" + 
				"      \"isbn\": \"9781449365035\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		String tokenPayLoad = "{\r\n" + 
				"  \"userName\": \"mimo5252\",\r\n" + 
				"  \"password\": \"Mimo@949658\"\r\n" + 
				"}";
		String deletePayLoad = "{\r\n" + 
				"		  \"isbn\": \"9781449365035\",\r\n" + 
				"		  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\"\r\n" + 
				"		}\r\n" + 
				"	";
		RestAssured.baseURI = "https://bookstore.toolsqa.com/";
		
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		responseFromGenerateToken = httpRequest.body(tokenPayLoad).post("Account/v1/GenerateToken");
		responseFromGenerateToken.prettyPrint();
		
		jsonString = responseFromGenerateToken.getBody().asString();
		tokenGenerated = JsonPath.from(jsonString).get("token");
		
		httpRequest.header("Authorization","Bearer "+tokenGenerated)
		.header("Content-Type","application/json");
		
		response = httpRequest.body(addPayLoad).post("BookStore/v1/Books");
		assertEquals(201, response.getStatusCode());
		System.out.println("Book add response code is: "+response.getStatusCode());
		response.prettyPrint();
		System.out.println("============================================================");
		
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("Authorization","Bearer "+tokenGenerated);
		
		
		response = httpRequest.body(deletePayLoad).delete("BookStore/v1/Book");
		response.prettyPrint();
		System.out.println("Book delete response code is: "+response.getStatusCode());
		
		 	
	}
	
//=====================================================================================	
	
	
	
	@Test(enabled = true)
	public void deleteBook()
	{
          // work very good
		RequestSpecification httpRequest;
		Response response;
		String encodedCredentialsAsString;
		
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		
		String deletePayLoad = "{\r\n" + 
				"		  \"isbn\": \"9781449325862\",\r\n" + 
				"		  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\"\r\n" + 
				"		}";
		
		String credentials = "mimo5252:Mimo@949658";
		byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
		encodedCredentialsAsString = new String(encodedCredentials);
		
		httpRequest = RestAssured.given();
		httpRequest.header("Authorization","Basic "+encodedCredentialsAsString);
		httpRequest.contentType(ContentType.JSON);
		
		response = httpRequest.body(deletePayLoad).delete("/BookStore/v1/Book");
		response.prettyPrint();
		System.out.println("Delete response code is: "+response.getStatusCode());
		
		
		
	}

	
	
	
	
	
	@Test(enabled = false)
	public void amIauthorized()
	{
          
		//work very good
		
		
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		
		String PayLoad = "{\r\n" + 
				"  \"userName\": \"mirsafwan\",\r\n" + 
				"  \"password\": \"Mimo@949658\"\r\n" + 
				"}";
		
		
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		
		Response response = httpRequest.body(PayLoad).post("/Account/v1/Authorized");
		response.prettyPrint();
		System.out.println("Response code is: "+response.getStatusCode());
	
	
	
	}
	
	@Test(enabled = false)
	public void removeBookFromUser()
	{   
		//work very good
		
		RequestSpecification httpRequest;
		Response response;
		String encodedCredentialsAsString;
		
		RestAssured.baseURI = "https://bookstore.demoqa.com";
		String removeDetails = "{\r\n" + 
				"  \"isbn\": \"9781449331818\",\r\n" + 
				"  \"userId\": \"bd18bf85-f718-4a82-8cf8-20a44af31ea8\"\r\n" + 
				"}";
		//9781449331818
	
		String credentials = "mimo5252:Mimo@949658";
		byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
		encodedCredentialsAsString = new String(encodedCredentials);
		
		httpRequest = RestAssured.given();
		httpRequest.header("Authorization","Basic "+encodedCredentialsAsString)
		.header("Content-Type","application/json");
		
		
		response = httpRequest.body(removeDetails).delete("/BookStore/v1/Book");
		System.out.println("Book delete response code is: "+response.getStatusCode());
		String s = response.body().asString();
		System.out.println(s);
		response.prettyPrint();
		
		
		
	}
	
}
