package oAuth;

import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import io.restassured.RestAssured;



public class TwitterAPI {
	@Test
	public void postTweet() {
		
		
		io.restassured.response.Response res=RestAssured.given().auth().oauth("AccessCode", "ConsumerCode", "ScretKey", "SecKey").post("https://api.twitter.com/1.1/statuses/update.json?status=This is my tweet via API");
		
		System.out.println(res.getStatusCode());
		
	}

}
