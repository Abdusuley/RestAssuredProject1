package authetication;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {

	//@Test(priority=1)
	void testBasicAuthentication()
	{
		given()
			.auth().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();	
		
	}
	
	//@Test(priority=2)
	void testDigestAuthentication()
	{
		given()
			.auth().digest("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();	
		
	}
	
	
	//@Test(priority=3)
	void testPreemptivecAuthentication()
	{
		given()
			.auth().preemptive().basic("postman","password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();	
		
	}
	
	@Test(priority=4)
	void testBearerTokenAuthentication()
	{
		String bearerToken="";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
		
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	
	//@Test
	void testOAuth1Authentication()
	{
		given()
			.auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate") // this is for OAuth1.0 authentication
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	//@Test
	void testOAuth2Authentication()
	{
		given()
		.auth().oauth2("")
	.when()
		.get("https://api.github.com/user/repos")
	.then()
		.statusCode(200)
		.log().all();
	}
	
	
	
//	@Test
	void testAPIKeyAuthentication()
	{
		//Method1
		/*given()
			.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c") //appid is APIKey
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		.then()
			.statusCode(200)
			.log().all();
		*/
		
		//Method2
		
		given()
			.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
			
			.pathParam("mypath","data/2.5/forecast/daily")
		
			.queryParam("q", "Delhi")
			
			.queryParam("units", "metric")
			
			.queryParam("cnt", "7")
			
			
		.when()
			.get("https://api.openweathermap.org/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
		
		
		
	}
	
}







