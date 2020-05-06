package com.qa.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Authorization {
	
	@Test
	void Authorization() {
		RestAssured.baseURI="https://6lbilgditb.execute-api.us-east-1.amazonaws.com/QA";
		//Request object(whenever we send the request to server then we use this reference variable)
				RequestSpecification http=RestAssured.given();
				
				//Basic Authentication
				PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme(); // Using this object we can pass user name and password
				auth.setUserName("aaaa");
				auth.setPassword("***");
				RestAssured.authentication=auth;
				//Response object
				Response response=http.request(Method.GET,"/GetAircraftMaster");
				//Print response in console window
				String responseBody=response.getBody().asString();
				System.out.println("Response Body:"+responseBody);
		
	}

}
