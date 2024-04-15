package day03;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Headers_Demo {
	
//	@Test(priority=1)
	void test_Headers() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
//			.log().all()
		;
	}
	
	@Test(priority=2)
	void get_Headers() {
		
		Response response = given()
		.when()
			.get("https://www.google.com/");
//		.then();
		
		//getting single header info
		String header_value = response.getHeader("Content-Type");
		System.out.println(header_value);
		
		//getting all headers info
		Headers myHeaders = response.getHeaders();
		for(Header hd : myHeaders) {
			System.out.println(hd.getName()+" =======> "+hd.getValue());
		}
	
	}

}
