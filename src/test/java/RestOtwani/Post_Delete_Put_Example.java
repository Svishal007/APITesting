package RestOtwani;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_Put_Example {

	@Test(enabled = false)

	public void testPost() {

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JSONObject js = new JSONObject();

		js.put("id", "7");
		js.put("title", "Selenium Webdriver");
		js.put("author", "Vishal");

		request.body(js.toJSONString());

		Response res = request.post("http://localhost:3000/posts");

		int code = res.statusCode();

		Assert.assertEquals(code, 201);

	}

	@Test(priority = 1)

	public void testDelete() {

		RequestSpecification request = RestAssured.given();

		Response res = request.delete("http://localhost:3000/posts/8");

		int code = res.statusCode();

		Assert.assertEquals(code, 200);

	}

}
