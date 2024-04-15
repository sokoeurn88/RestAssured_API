package day03;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Path_and_QueryParameters {
	
	//compete url: https://reqres.in/api/users?page=2
	//Domain name: https://reqres.in/api/
	//path parameter: users?
	//query paramether: page=2

	@Test
	void test_Query_and_Path_Parameters() {
		
		given()
			.pathParam("mypath", "users")
			.queryParam("page",	2)
			.queryParam("id", 10)
		.when()
			.get("https://reqres.in/api/{mypath}") //after giving pathParam (users), queryPath will come along
		.then()
			.statusCode(200)
			.log().all();
			
	}

}
