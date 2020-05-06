package com.qa.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Print_All_HeaderValue {
	
	@Test
	void printAllHeaderContent() {
		
		//Specify base URI
				RestAssured.baseURI="https://6lbilgditb.execute-api.us-east-1.amazonaws.com/QA";
				
				//Request object(whenever we send the request to server then we use this reference variable)
				RequestSpecification http=RestAssured.given();
				//Response object
				Response response=http.request(Method.GET,"/GetAircraftMaster");
				//Print response in console window
				String responseBody=response.getBody().asString();
				System.out.println("Response Body:"+responseBody);
				
				Headers allheader= response.headers(); //Capture all headers from response(it's storing data in the form of key and value pair
				
				for(Header header:allheader) {
					//Header is class
					System.out.println(header.getName()+"="+header.getValue());
					
					//getName will return key of header
					//getValue will return value of header
					
				}

	}

}
