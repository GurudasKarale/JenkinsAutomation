package Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {
	
	public static RequestSpecification req;
	
	public static RequestSpecification requestSpecificationUtil() throws IOException {
		
		if(req==null) {
			
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		
		req = new RequestSpecBuilder().setBaseUri("https://practice.expandtesting.com").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
		
		return req;
			
		}
		
		return req;
	}

}
