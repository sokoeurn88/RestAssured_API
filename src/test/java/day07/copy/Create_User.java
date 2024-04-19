package day07.copy;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class Create_User {
	
	
	//Chaining Sequence: create user => get user => update user => delete user
	
	@Test
	void test_Create_User(ITestContext context) {
		
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bear_Token = "5459d08b652f8145927b96adb79e2e0366ad499d1900f5582a13b390d44087df";
		
		// int id is for only for id body response
		 int id = given()
			.headers("Authorization", "Bearer "+bear_Token)			//"Bearer " has to place before actual token
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id")
			
			;
			
		 System.out.println(id);

		 context.getSuite().setAttribute("user_id", id);		//make id as global variable
			
//		.then();		//Then is comment in order to get response body
	}

}
