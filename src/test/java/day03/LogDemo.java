package day03;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class LogDemo {
	
	@Test
	void test_log() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
//			.log().body()
//			.log().headers()
			.log().cookies()		//no cookies will be shown
			.log().all()
		
		;
		
		
		
	}

}
