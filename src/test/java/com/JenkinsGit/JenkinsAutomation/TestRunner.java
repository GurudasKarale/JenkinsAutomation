package com.JenkinsGit.JenkinsAutomation;

import java.io.IOException;

import Utils.SpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;


public class TestRunner {

	 
	
	public static void main(String []args) throws IOException {
		
		RequestSpecification req = SpecBuilder.requestSpecificationUtil();
		String token = "2b803909d003438abc0618788a6c1567fe201522256a4ddbb6989294355a3016";
		
		RequestSpecification reqUserProfile = given().header("x-auth-token",token).log().all().spec(req);
		
		String responseServerHealth = reqUserProfile.when().get("/notes/api/users/profile").then().log().all().extract().response().asString();
		
		JsonPath js = new JsonPath(responseServerHealth);
		String message = js.get("message");
		System.out.println(message);
		
	}
	
}


//"name": "abcd",
//"email": "b@gmail.com"
//pass : 123456