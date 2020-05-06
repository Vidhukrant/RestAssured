package com.qa.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {
	
	@Test
	public void test_api() {
		
		given().
		when().
		 get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		 assertThat().
		  body("MRData.CircuitTable.Circuits.circuitId",hasSize(22));
	}

}
