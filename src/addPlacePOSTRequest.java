import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;
import files.reUsableMethods;

public class addPlacePOSTRequest {

	public static void main(String[] args) {

		// 1. given() - specify queryParam, header and body of POST request
		// 2. when() - "resource" will be POST in this case and "http method"
		// 3. then() - validation/Assertion

		// Specify BaseURI
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Specify when
		System.out.println("-------->Start of AddPlace");
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response()
				.asString();

		System.out.println("-------->Printing Complete addPlace response");
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeID = js.getString("place_id");
		String newAddress = "Discovery Gardens";
		System.out.println("-------->PrintPlaceID");
		System.out.println(placeID);

		
		System.out.println("-------->Updating place");
		// put request
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeID + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		System.out.println("-------->Start of get request");
		// get request
		String getplaceRepsonse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
				.when().get("/maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();

		JsonPath js1= reUsableMethods.rawToJson(getplaceRepsonse);
		String actuallAddress = js1.getString("address");
		System.out.println(actuallAddress);
		
		Assert.assertEquals(actuallAddress,"Discovery Gardens");

	}

}
