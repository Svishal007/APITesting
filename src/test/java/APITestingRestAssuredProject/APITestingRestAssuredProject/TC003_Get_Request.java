package APITestingRestAssuredProject.APITestingRestAssuredProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Get_Request {

	@Test
	void getGoogleMaps() {
		// specify BAse URl
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response Object
		Response response = httpRequest.request(Method.GET, "/api/v1/employees");

		// Print response on console

		String responsbody = response.getBody().asString();

		System.out.println("Response Body:  " + responsbody);

		// CApture details of headers from response

		String cacheControl = response.header("Cache-Control");
		System.out.println("Cache Control :  "+ cacheControl);
		Assert.assertEquals(cacheControl, "max-age=31536000");
		
		String AccessControl = response.header("Access-Control-Allow-Origin");
		System.out.println("Access Control Origin :  "+ AccessControl);
		Assert.assertEquals(AccessControl, "*");
	}

}
