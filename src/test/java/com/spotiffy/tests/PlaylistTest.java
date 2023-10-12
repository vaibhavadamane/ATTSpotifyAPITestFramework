package com.spotiffy.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotiffy.api.PlayListAPI;
import com.spotiffy.pojo.Playlist;

import AuthManger.TokenCreator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PlaylistTest
{

	String playlistId;
	String reqName;

	@Test(priority=1,enabled=false)
	public void creatPlaylist()
	{
		Playlist playlist = new Playlist();
		
		playlist.setName("Devbhakti gett123");
		playlist.setDescription("Tseries Collections");
		playlist.setPublic(true);
		
		Response respoances = PlayListAPI.post(playlist, TokenCreator.createToken());
		
		Playlist resPlaylist = respoances.as(Playlist.class);
		
		String respoName = resPlaylist.getName();
		
		reqName = playlist.getName();
		
		Assert.assertEquals(reqName, respoName);
		
		playlistId = resPlaylist.getId();
	}
	
	@Test(priority=2,enabled=false)
	public void getPlaylist()
	{
		Response respo = PlayListAPI.get(playlistId, TokenCreator.createToken());
		
		Playlist rpo = respo.as(Playlist.class);
		
		Assert.assertEquals(rpo.getName(), reqName);
	}
	
	@Test(priority=3,enabled=false)
	public void updatePlaylist()
	{
        Playlist playlist = new Playlist();
		
		playlist.setName("Bhajan Kirtan Song");
		playlist.setDescription("Bhajan Kirtan Collection");
		playlist.setPublic(true);
		
		Response response = PlayListAPI.put(playlist, playlistId, TokenCreator.createToken());
		int sc = response.getStatusCode();
		Assert.assertEquals(sc, 200);
	}
	
//	Negative Scenario
	
	@Test(priority=4, enabled=true)
	public void shouldNotBeAuthorised()
	{
        Playlist playlist = new Playlist();
		
		playlist.setName("Devbhakti gett123");
		playlist.setDescription("Tseries Collections");
		playlist.setPublic(true);
		
		Response respoances = PlayListAPI.post(playlist, "1234");
		int sc = respoances.getStatusCode();
		
		Assert.assertEquals(sc, 401);
		
		
	}
}
