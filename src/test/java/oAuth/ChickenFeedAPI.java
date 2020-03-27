package oAuth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ChickenFeedAPI {

	@Test(enabled = false)
	public void chickenFeed() {
		//You need to create am application first to test
		
		Response resp=
		RestAssured.given().auth().oauth2("GenerteToken").post("http://coop.apps.symfonycasts.com/api/865/chickens-feed");
		
		System.out.println("Status Code :  "+ resp.getStatusCode());
		System.out.println("Body COde:  "+resp.getBody().asString());

	}
	
	@Test
	public void chickenFeedClientCredentials() {
		Response resp=	RestAssured.given().formParam("Client ID","APITest").formParam("Client Secret", "426a4a674853f803199b09e82e2a79353f5483ba").formParam("grant_type", "client_credentials").post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp.jsonPath().prettify());
	}

}
