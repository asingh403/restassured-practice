package GETAPIs;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETAPIRequestWithBDD {
	
	@Test
	public void getUserAPITest() { 
		given().log().all()
			.when().log().all()
				.get("https://fakestoreapi.com/products")
					.then().log().all()
						.assertThat()
							.statusCode(200)
								.contentType(ContentType.JSON)
									.header("Connection", "keep-alive")
										.and()
											.body("$.size()", equalTo(20))
												.and()
													.body("id", is(notNullValue()))
														.and()
															.body("title", hasItem("SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s"));
		
	}
}
