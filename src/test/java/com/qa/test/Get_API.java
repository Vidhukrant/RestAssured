package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_API {
	
	@Test
	public void TC_001() {
		
		//Specify base URI
		RestAssured.baseURI="https://6lbilgditb.execute-api.us-east-1.amazonaws.com/QA/PolicyMasterData/GTA";
		
		//Request object(whenever we send the request to server then we use this reference variable)
		RequestSpecification http=RestAssured.given();
		//Response object
		Response response=http.request(Method.GET);
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body:"+responseBody);
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println("Status line:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
