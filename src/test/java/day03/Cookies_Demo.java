package day03;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies_Demo {
	
//	@Test(priority=1)
	void test_Cookies() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.cookies("AEC", "AQTF6HwXp46Z4LltGohD5wHA-dXt4b4iQG5zsT1bn0jErW5gGIpKIIUrOw")
			.log().all()
		;
	}
	
	@Test(priority=1)
	void test_Cookies_Info() {
		
		Response response = given()
		
		.when()
			.get("https://www.google.com/"); 	//to store the response in Response response, we have to end ; here
		
		
		//To get single cookies info
		String cookie_value = response.getCookie("AEC");
		System.out.println(cookie_value);
		
		//geting all cookies info
		Map<String, String> cookies_values = response.getCookies();		//this cookies_values conatians all cookies
		
		//to get all key using: keySet()
		for( String k:cookies_values.keySet()) {
			
			String cookie_value00 = response.getCookie(k);
			System.out.println(k+" : "+cookie_value00);
		}
		
			
		//cut off .then(). from given().when()	
//		.then()
//		.cookies("AEC", "AQTF6HwXp46Z4LltGohD5wHA-dXt4b4iQG5zsT1bn0jErW5gGIpKIIUrOw")
//		.log().all()
		
		
		
	}

}
