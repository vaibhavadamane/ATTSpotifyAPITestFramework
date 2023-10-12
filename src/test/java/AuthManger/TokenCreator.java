package AuthManger;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class TokenCreator 
{

	@Test
	public static String createToken()
	{
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("client_id", "bb0a88ca948a4ab2959f671c7814b155");
		map.put("client_secret", "0a6125d98f1e44af865ae1e79105bba8");
		map.put("grant_type", "refresh_token");
		map.put("refresh_token", "AQBjIBCADYGAKJwaWVcoiWgw-xN-egIDzjZKeSbnq9uN_ySahF1RQbHIH0KZwVbvy2tqthi98zlpy_HLsb3-sIBc-5EcW0QWCU8m-2J0Rsi3f44GrxVVAdqX9es0yLr98c8");
		
		RestAssured.baseURI = "https://accounts.spotify.com";
		
		Response res = given()
		
		.formParams(map)
		
		.contentType(ContentType.URLENC)
		
		.when()
		
		.post("/api/token")
		
		.then()
		
		.extract()
		
		.response();
		
		if(res.statusCode()!=200)
		{
			throw new RuntimeException("Failed to create the acess token");
		}
		
		String token = res.path("access_token");
		
		return token;
		
//		System.out.println(token);

		
	}

}
