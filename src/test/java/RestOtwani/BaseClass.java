package RestOtwani;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	@BeforeClass
	void setup() {
		RestAssured.authentication= RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
	}
	

}
