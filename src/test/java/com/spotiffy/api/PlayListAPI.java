package com.spotiffy.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.spotiffy.pojo.Playlist;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PlayListAPI 
{

	public static Response post(Playlist playlist,String token)
	{
         return given(SpecBulider.reqSpec())
        		 
//        .header("Authorization", "Bearer "+token )		
        		 
        .auth().oauth2(token)		 
		
		.body(playlist)
		
		.when()
		
		.post("/users/31vvwjrggfwftqklkq3q3pprbdqe/playlists")
		
		.then()
		
		.spec(SpecBulider.resSpec())
		
		.extract()
		
		.response();
	}
	
	public static Response get(String playlistId,String token)
	{
         return given(SpecBulider.reqSpec())
        		 
//        .header("Authorization", "Bearer "+token )			 
		
        .auth().oauth2(token) 		 
        		 
		.when()
		
		.get("/playlists/"+playlistId)
		
		.then()
		
		.spec(SpecBulider.resSpec())
		
		.extract()
		
		.response();
		
	}
	
	public static Response put(Playlist playlist, String playlistId, String token)
	{
         return given(SpecBulider.reqSpec())
		
		.body(playlist)
		
//		.header("Authorization", "Bearer "+token )	
		
		.auth().oauth2(token)
		
		.log().all()
		
		.when()
		
		.put("/playlists/"+playlistId)
		
		.then()
		
//		.spec(SpecBulider.resSpec())
		
		.extract()
		
		.response();
         
	}
}
