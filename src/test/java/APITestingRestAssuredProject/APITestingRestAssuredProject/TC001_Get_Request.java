package APITestingRestAssuredProject.APITestingRestAssuredProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {

	@Test
	void getweatherDetails() {
		// specify BAse URl
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response Object
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Print response on console

		String responsbody = response.getBody().asString();
		
		System.out.println("Response Body:  "+responsbody);
		
		//Status code validation
		
		int statuscode=response.getStatusCode();
		
		System.out.println("Status Code :  "+ statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
		//StatusLine verification
		
		String statusLine = response.statusLine();
		
		System.out.println("Status Line :  "+ statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
 