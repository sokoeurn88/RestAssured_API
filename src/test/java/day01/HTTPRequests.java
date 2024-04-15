package day01;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

/*
given() - content type, set cookies, add authorization, add param, set headers, info etc...
when() - get, post, put, delete
then() - validate status code, extract reponse, extract headers cookies, response body...
*/

public class HTTPRequests {
	//global variable
	int id;
	
	@Test(priority=1)
	void getUsers() {
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	
	@Test(priority=2)
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name", "sokouern");
		data.put("job", "Businessman");
		
		id = given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")	//will return some response
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	@Test(priority = 3, dependsOnMethods= {"createUser"})
	void updateUser() {
		
		HashMap data = new HashMap();
		data.put("name", "chhay");
		data.put("job", "Software Engineer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)	//will return some response
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority = 4)
	void deleteUser() {
		
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
		
	}


}
