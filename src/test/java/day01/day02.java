package day01;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
public class day02 {
	
//Post Request body using HashMap
	
//	@Test(priority=1)
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		data.put("name", "sok");
		data.put("location", "dallas");
		data.put("phone", "5012153790");
		
		String courseArr[] = {"C", "C++"};
		
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/item")
		.then()
			.statusCode(201)
			.body("name", equalTo("sok"))
			.body("location", equalTo("dallas"))
			.body("phone", equalTo("5012153790"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("content-Type", "application/json")
			.log().all();
	}
	
	
	//Create request Body using Json Library	
	
//	@Test(priority=2)
	void testPostUsingJsonLibrary() {
		
		JSONObject data1 = new JSONObject();
		
		data1.put("name", "koeurn");
		data1.put("location", "dallas");
		data1.put("phone", "5012153790");
		
		String courseArr[] = {"C", "C++"};
		
		data1.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data1.toString())
		.when()
			.post("http://localhost:3000/item")
		.then()
			.statusCode(201)
			.body("name", equalTo("koeurn"))
			.body("location", equalTo("dallas"))
			.body("phone", equalTo("5012153790"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("content-Type", "application/json")
			.log().all();
	}

	//Create request Body using Pojo Class
	
//	@Test(priority=3)
	void testPostUsingPOJOCLASS() {
		
		Pojo_PostRequests data2 = new Pojo_PostRequests();
		
		data2.setName("koeurn chhay");
		data2.setLocation("dallas");
		data2.setPhone("5012153790");
		String courseArr[] = {"C", "C++"};
		data2.setCourses(courseArr);
		
		given()
			.contentType("application/json")
			.body(data2)
		.when()
			.post("http://localhost:3000/item")
		.then()
			.statusCode(201)
			.body("name", equalTo("koeurn chhay"))
			.body("location", equalTo("dallas"))
			.body("phone", equalTo("5012153790"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("content-Type", "application/json")
			.log().all();
	}
	
//Create request Body using External Json File
	
	@Test(priority=3)
	void testPostUsingExternalJsonFile() throws FileNotFoundException {
		
		File f = new File(".//Body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data3 = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data3.toString())				//if the data has in Json Object, convert data to String
		.when()
			.post("http://localhost:3000/item")
		.then()
			.statusCode(201)
			.body("name", equalTo("koeurn chhay"))
			.body("location", equalTo("dallas"))
			.body("phone", equalTo("5012153790"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("content-Type", "application/json")
			.log().all();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test(priority=2)
	void testDelete() {
		given()
		.when()
			.delete("http://localhost:3000/item/8860")
		.then()
			.statusCode(200);
	}
	

}
