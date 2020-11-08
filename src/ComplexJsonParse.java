import static io.restassured.RestAssured.form;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		/*
		 * 1. Print No of courses returned by API 2. Print Purchase Amount 3. Print
		 * Title of the first course 4. Print All course titles and their respective
		 * Prices 5. Print no of copies sold by RPA Course 6. Verify if Sum of all
		 * Course prices matches with Purchase Amount
		 */

		// 1. Print No of courses returned by API
		System.out.println("1. Print No of courses returned by API");
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);

		// 2. Print Purchase Amount
		System.out.println("2. Print Purchase Amount");
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);

		// 3. Print Title of the first course
		System.out.println("3. Print Title of the first course");
		String firstCourseTitleJsonPath = js.get("courses[0].title");
		System.out.println(firstCourseTitleJsonPath);

		// 4. Print All course titles and their respective Prices
		System.out.println("4. Print All course titles and their respective Prices");

		for (int i = 0; i < count; i++) {
			String courcesTitleString = js.get("courses[" + i + "].title");
			System.out.println(courcesTitleString);
			System.out.println((js.get("courses[" + i + "].Price")).toString());
		}
		// 5. Print no of copies sold by RPA Course

		System.out.println(" 5. Print no of copies sold by RPA Course");
		count = 0;
		for (int j = 0; j < count; j++) {

			String allCoursesTitle = js.get("courses[" + j + "].title");
			if (allCoursesTitle.equalsIgnoreCase("RPA")) {
				int copies = js.get("courses[" + j + "].copies");
				System.out.println(copies);
				break;
			}

		}
		count = 0;
		// 6. Verify if Sum of all Course prices matches with Purchase Amount
		int purchaseAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println("PurchaseAmount="+purchaseAmount);
		int sum=0;
		int sizeOfArray= js.getInt("courses.size()");
		for(int x=0; x<sizeOfArray;x++)
		{
			int indPrice= js.getInt("courses["+x+"].Price");
			int indCopies= js.getInt("courses["+x+"].copies");
			int Price= indPrice*indCopies;
			sum=sum+Price;
		}
		System.out.println(sum);
		if(sum == purchaseAmount) {
			System.out.println("Assertion Passed");
		}else {System.out.println("Assertion Failed");}

	}

}
