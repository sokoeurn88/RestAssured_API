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

public class Update_User {
	
	@Test
	void test_Update_User(ITestContext context) {
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bear_Token = "5459d08b652f8145927b96adb79e2e0366ad499d1900f5582a13b390d44087df";
		int id = (int) context.getSuite().getAttribute("user_id");		//get "user_id" from test_Create_User(){}
		
		given()
			.headers("Authorization", "Bearer "+bear_Token)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all()
		;
	}

}
