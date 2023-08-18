package GETAPIs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETAPIRequestTest {
	
//	https://gorest.co.in/public/v2/users/
	RequestSpecification request;
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://gorest.co.in/";
		request= RestAssured.given();
		request.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6");
	}
	
	@Test
	public void getUserAPITest() {
		
		Response response= request.get("public/v2/users/");
		
		
		int statusCode = response.statusCode();
		System.out.println("Status Code : "+ statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		String statusMsg = response.statusLine();
		System.out.println(statusMsg);
		
		//fetch the body
		response.prettyPrint();
		
		//fetch header
		List<Header> headerList= response.getHeaders().asList();
		//Sys tem.out.println(headerList);
		
		System.out.println(response.headers().asList());
		
		for(Header h:headerList) {
			System.out.println(h.getName()+" : "+h.getValue());
		}		
		
	}
	
	/**
	 * https://app.box.com/file/1262176598238?sb=/activity
	 * 1:17:25
	 */
	
	@Test
	public void getAllUsersWithQueryParameter_WithHashMap_APITest() {
		
		Map<String, String> queryParamsMap = new HashMap<>();
		queryParamsMap.put("name", "Naveen");
		queryParamsMap.put("gender", "male");
		
		request.queryParams(queryParamsMap);
		
		Response response= request.get("public/v2/users/");
		
		
		int statusCode = response.statusCode();
		System.out.println("Status Code : "+ statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		String statusMsg = response.statusLine();
		System.out.println(statusMsg);
		
		//fetch the body
		response.prettyPrint();
		
		//fetch header
		List<Header> headerList= response.getHeaders().asList();
		//Sys tem.out.println(headerList);
		
		System.out.println(response.headers().asList());
		
		for(Header h:headerList) {
			System.out.println(h.getName()+" : "+h.getValue());
		}	
	
	}

}
