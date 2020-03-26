package APITestingRestAssuredProject.APITestingRestAssuredProject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Request {

	@Test
	void RegistrationSuccessful() {

		// specify BAse URl
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Request Payload along with post Request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Vishal");
		requestParams.put("LastName", "Sonkusare");
		requestParams.put("Username", "VishalS007");
		requestParams.put("Password", "Vishal001");
		requestParams.put("Email", "Sonkusare.vishal1@gmail.com");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString()); // attach data to request
		// Response object
		Response response = httpRequest.request(Method.POST, "/register");
		// Print Response code in COnsole
		String responsbody = response.getBody().asString();
		System.out.println("Response Body:  " + responsbody);
		// Status code validation
		int statuscode = response.getStatusCode();
		System.out.println("Status Code :  " + statuscode);
		Assert.assertEquals(statuscode, 400);
		//SuccessCode Validation
		String successCode = response.jsonPath().get("SuccessCode");
		
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

	}
}
