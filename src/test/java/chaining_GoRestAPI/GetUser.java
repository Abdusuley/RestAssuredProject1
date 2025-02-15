package chaining_GoRestAPI;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	public void test_getuser(ITestContext context)
	{	
		// Chain (Share Data with) APIs in same Test Tag
		//  int id = (Integer) context.getAttribute("user_id");
		
		// Chain (Share Data with) APIs in same Suite Tag	
		 int id = (Integer) context.getSuite().getAttribute("user_id");
		
		String bearerToken="c35e10e748c6f113775527bcef204e9929b4c9f4b995a8ee253eec46aed57b06";  // github token
			
			
		given()
			.headers("Authorization","Bearer " +bearerToken)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
						
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
}
