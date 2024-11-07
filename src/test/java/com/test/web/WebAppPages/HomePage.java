package com.test.web.WebAppPages;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
//import static io.restassured.*;
import  io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;


public class HomePage {
	
	//private static String baseuri = "https://fake-json-api.mock.beeceptor.com/users";
	private static String baseuri = "https://client.badssl.com";
	
	
	@BeforeTest
	public void beforeTest() {
		String keystorePath = "/Users/sadhwinprasadts/Documents/JavaProject/WebApp_Testing/WebAppTesting/src/test/badssl.p12";
		String truststorePath = "/Users/sadhwinprasadts/Documents/JavaProject/WebApp_Testing/WebAppTesting/src/test/truststore";
		
		RestAssured.config = RestAssured.config.sslConfig(
				sslConfig().with()
					//.trustStore()
					.trustStore(truststorePath,"Sandisk!123")
					
					.trustStoreType("PKCS12")
					//.keyStore("./badssl.p12", "badssl.com")
					.keyStore(keystorePath, "badssl.com")
					.keystoreType("PKCS12")
				);
	}
	
	
	@Test(enabled=true)
	public void demoTest()  {
		Response res = given()
				.when()
					.get(baseuri)
				.then()
					.assertThat().statusCode(200)
					.extract()
					.response();
					
				System.out.println(res.asString());
	}
	
	
	@Test(enabled= true)
	public void testSSLConnection() {
		Response res = given()
				.when()
					.get(baseuri)
				.then()
					.assertThat().statusCode(200)
					.extract()
					.response();
					
				System.out.println(res.asString());
	
	}

}
