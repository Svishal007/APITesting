package RestOtwani;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	void testResponseCode(){
		
		int statusCode= get().getStatusCode();
		System.out.println("Status Code" + statusCode);
		
		Assert.assertEquals(statusCode, 200);
	}
	@Test
	void testBody(){
		
		String Body = get("").asString();
		int time =(int) get().getTimeIn(TimeUnit.SECONDS);
		
		System.out.println("Test Body is:  "+Body + "ResponseTime:  " + time);
	}
}
