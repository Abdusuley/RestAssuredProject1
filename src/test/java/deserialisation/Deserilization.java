package deserialisation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DiffWaysToCreatePostRequestBody.Pojo_PostRequest;
import serialisation.Student;

//Pojo  ---- Serilize-->  JSON Object -- de-serilize----->POjo

public class Deserilization {

	
	
	// Json -----> Pojo    ( De-Serilization)
		@Test
		void convertJson2Pojo() throws JsonProcessingException
		{
			
			String jsondata="{\r\n"
					+ "  \"name\" : \"Scott\",\r\n"
					+ "  \"location\" : \"France\",\r\n"
					+ "  \"phone\" : \"123456\",\r\n"
					+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
					+ "}";
			
			
			//convert json data---> Pojo object
			
			ObjectMapper objMapper=new ObjectMapper();
			
			
			Student stupojo=objMapper.readValue(jsondata,Student.class); //convert json to pojo
			
			System.out.println("Name:"+stupojo.getName());
			System.out.println("Location:"+stupojo.getLocation());
			System.out.println("Phone:"+stupojo.getPhone());
			System.out.println("Course 1:"+stupojo.getCourses()[0]);
			System.out.println("Course2:"+stupojo.getCourses()[1]);	
			
			
		}
		
		
		
	
	
	
	
	
	
	
}
