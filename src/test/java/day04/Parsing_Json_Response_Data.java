package day04;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Parsing_Json_Response_Data {
	
//	@Test
	void test_Json_Response() {
		
		//approach 1
		given()
		.when()
			.get("http://localhost:3000/item")
		.then()
			.statusCode(200)
			.header("Access-Control-Allow-Headers", "content-type")
			.header("Content-Type", "application/json")
			.body("[13].location", equalTo("dallas"))
			;
	}
	
//	@Test
	void test_Json_Response2() {
		
		//approach 2 this is most used 
		Response response = given()
		.when()
			.get("http://localhost:3000/item")
//		.then()
//		.statusCode(200)
//		.header("Access-Control-Allow-Headers", "content-type")
//		.header("Content-Type", "application/json")
//		.body("[13].location", equalTo("dallas"))
		;
		
		//this part is normal Java Assertions
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		
		String mypath = response.jsonPath().get("[13].location").toString();
		Assert.assertEquals(mypath, "dallas");
	}
	
//	@Test
//	void test_Json_Response3() {
//		
//		//approach 2 this is most used 
//		Response response = given()
//				.when()
//				.get("http://localhost:3000/item");
//		
//		//create JSONObject class
//		JSONObject jo = new JSONObject(response.asString());		//convert response to Json Object Type
//		
//		//goal to read all names 
//		
//		for(int i=0;i<jo.length();i++) {
//			
//			String name = jo.get("name").toString();
//			System.out.println(name);
//			
//		}
//
//	}
	

}
