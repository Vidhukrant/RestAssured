package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Validating_Header_Part {
	
	@Test
	void validate_header_content() {
		
		//Specify base URI
				RestAssured.baseURI="https://6lbilgditb.execute-api.us-east-1.amazonaws.com/QA";
				
				//Request object(whenever we send the request to server then we use this reference variable)
				RequestSpecification http=RestAssured.given();
				//Response object
				Response response=http.request(Method.GET,"/GetAircraftMaster");
				//Print response in console window
				String responseBody=response.getBody().asString();
				System.out.println("Response Body:"+responseBody);
				//Capture details of header from response
				String ContentType=response.header("Content-Type");
				System.out.println("The content type is:"+ContentType );
				Assert.assertEquals(ContentType, "application/json");
				String Connection=response.header("Connection");
				System.out.println("Connection is:"+Connection);
				Assert.assertEquals(Connection, "keep-alive");
				//We can capture details of header in same way as above
				

	}

}
