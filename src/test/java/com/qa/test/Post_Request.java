package com.qa.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request {
	
	@Test
	 void DeleteAircraft() {
		
		//Specify base URI
		RestAssured.baseURI="https://6lbilgditb.execute-api.us-east-1.amazonaws.com/QA";
		
		//Request object(whenever we send the request to server then we use this reference variable)
		RequestSpecification http=RestAssured.given();
		//Request payload sending along with post request
		JSONObject reqParams=new JSONObject();
		reqParams.put("PolicyTxnId", "1802504");
		reqParams.put("PolicyAircraftId", "2128");
		http.header("Content-Type","application/json");
		//Attach data to the request
		http.body(reqParams.toJSONString());
		
		//Response object
		Response response=http.request(Method.POST,"/DeletePolicyAircraft");
		//Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body:"+responseBody);
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Validate Json response value	
		String res=response.jsonPath().get("ErrorCode");
		System.out.println("Error code is:"+res);
		//Assert.assertEquals(res, "null");
		
		}


}
