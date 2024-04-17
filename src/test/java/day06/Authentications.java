package day06;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authentications {
	
//	@Test(priority=1)
	void test_Basic_Authenication() {
		
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
			;
	}
	
//	@Test(priority=2)
	void test_Digest_Authenication() {
		
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		;
	}
	
//	@Test(priority=3)
	void test_Preemtive_Authenication() {
		
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		;
	}
	
//	@Test(priority=4)
	void test_Bear_Token_Authenication() {
		
		String bear_Token = "ghp_5PzQno9ckP1r2ULqi5vw0uM92V";			//for security, this bear token is not complete.
		
		given()
			.headers("Authorization", "Bear"+bear_Token)
		.when()
			.get("https://github.com/sokoeurn88/RestAssured_API")
		.then()
			.statusCode(200)
			.log().all();
		;
	}
	
//	@Test(priority=5)
	void test_Oauth_2_0_Authenication() {
		
		given()
			.auth().oauth2("ldkdkjdof594fjrindsl")			//Oauth2.0 is sample only
		.when()
			.get("https://github.com/sokoeurn88/RestAssured_API")
		.then()
			.statusCode(200)
			.log().all();
		;
	}

}
