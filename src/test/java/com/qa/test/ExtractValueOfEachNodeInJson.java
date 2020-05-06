package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtractValueOfEachNodeInJson {
	
	@Test
	void extract_value() {
		
       RestAssured.baseURI="https://6lbilgditb.execute-api.us-east-1.amazonaws.com/QA";
		
		//Request object(whenever we send the request to server then we use this reference variable)
		RequestSpecification http=RestAssured.given();
		//Response object
		Response response=http.request(Method.GET,"/GetAircraftMaster");
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body:"+responseBody);
		
		JsonPath jsonpath=response.jsonPath();
		System.out.println("value:"+jsonpath.get("Registration"));// Accessing the value from json
		Assert.assertEquals(jsonpath.get("Registration"), "null");

	}

}
