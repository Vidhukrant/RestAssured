package datadriventesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_PostData {
	
	@Test
	void test() {
		
        RestAssured.baseURI="https://6lbilgditb.execute-api.us-east-1.amazonaws.com/QA";
		
		RequestSpecification http=RestAssured.given();
		JSONObject request=new JSONObject();
		request.put("AircraftId", "2343");
		request.put("Registration", "Reg-2");
		request.put("SerialNum", "Ser-1");
		request.put("ClassId", "3");
		request.put("TypeId", "2");
		request.put("Make", "Dauphin");
		request.put("Model", "4000");
		request.put("IsInActive", "false");
		http.body(request.toJSONString());
		Response response=http.request(Method.POST,"/SaveAircraftMaster");
		
		String responseBody=response.getBody().asString();
		int resCode=response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		
	}

}
