package RestOtwani;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAssuredDemo  extends BaseClass{
	@Test
	public void test1() {
		
		int responseCode = RestAssured.given().get().getStatusCode();
		
		System.out.println("Response Code from server:   "+responseCode);
				
	}

}
