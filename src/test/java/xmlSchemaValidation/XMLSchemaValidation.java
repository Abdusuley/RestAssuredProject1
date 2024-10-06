package xmlSchemaValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class XMLSchemaValidation {

	@Test
	void xmlSchemavalidation()
	{
		String json = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"PetCat\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"Cat\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		Response response = given().header("accept","application/xml").header("Content-Type","application/json").body(json).
		
		when()
			.post("https://petstore.swagger.io/v2/pet");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.contentType(), "application/xml");
		
		response.then()   
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("petstore.xsd"));	
		
	}
	
}
