import org.testng.annotations.Test;


import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	

	@Test
	public void purchaseAmountValidation()
	{
		JsonPath js = new JsonPath(payload.CoursePrice());
		int purchaseAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
	}

	
	
	
}
