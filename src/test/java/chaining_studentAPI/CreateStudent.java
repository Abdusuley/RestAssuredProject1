package chaining_studentAPI;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

public class CreateStudent{
	//Post request body creation using using Org.JSON
	@Test
	public void createStudent(ITestContext context)
	{
		JSONObject data=new JSONObject();
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","123456");
		String coursesArr[]= {"C","C++"};
		data.put("courses", coursesArr);
				
		
		String id=given()
					.contentType("application/json")
					.body(data.toString())
		
				.when()
					.post("http://localhost:3000/students")
					.jsonPath().get("id");
		            System.out.println(id);
		
	// Chain (Share Data with) APIs in same Test Tag
		//context.setAttribute("stu_id", id);
	
	// Chain (Share Data with) APIs in same Suite Tag
		context.getSuite().setAttribute("stu_id", id);	
	
	}
}