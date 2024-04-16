package day05;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Parsing_XML_Response {
	
	@Test
	void test_XML_Response() {
		
		//approach 1
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml")
			.body("TravelerInformationResponse.page", equalTo("1"))
			
			;
		
	}

}
