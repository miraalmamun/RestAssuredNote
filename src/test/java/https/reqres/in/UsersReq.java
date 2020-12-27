package https.reqres.in;

import org.testng.annotations.Test;

import https.reqres.in.POJO.UsersRequest;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class UsersReq {

	@Test
	public void post() {
		UsersRequest ur = new UsersRequest();
		ur.setName("Mamun");
		ur.setJob("QA");
		UsersRequest as = given().auth().none().contentType(ContentType.JSON)
		.body(ur).when().post("https://reqres.in/api/users")
				.as(UsersRequest.class);
      
		System.out.println("Name: "+as.getJob());
		System.out.println("Job: "+as.getName());
		System.out.println("Id: "+as.getId());
		System.out.println(as.toString());
		
	}

}
