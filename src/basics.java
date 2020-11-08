import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class basics {

	public static void main(String[] args) {
		//validate that if the Add place API is working
		//Three main keywords used in RestAssuredAPI
			//1. given - all input details (for your POST req this section will include 1. "queryParam" 2. "header" 3."body" )
			//2. when  - submit the API (for your post request this section will include 1. "resource" 2. "http method")
			//3. Then  - validate the API (assertion)
		
		
		//1. set BaseURI
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ " \r\n"
				+ "").when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
		
		
		
	}

}
