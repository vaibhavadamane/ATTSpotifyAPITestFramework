package com.spotiffy.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBulider 
{

	public static RequestSpecification reqSpec()
	{
		return new RequestSpecBuilder()
		.setBaseUri("https://api.spotify.com")
	    .setBasePath("/v1")
		.setContentType(ContentType.JSON)
//		.addHeader("Authorization", "Bearer BQDSz2sLLf9S3LBeCUdXv7viuZwiPD3JDK0bigL1fzwAdeOlg40gZDRavWQ6SRieZsNIkWQgFw24wqWVLC9s5DjUS2teCwNUCutV-IXTk4GDI2ZQUjJASt-lUh0oKQqGaM-bDcWHlZXsqT1ZETVvREoJGdOb3RI6geSqSrwRcgxvXrD1W6cgLjOLqyBQriPMUKcuNb-2GIfmAIJ07AVVy_N-LjFL5Nr7ARpMlKRZGGkshgtZ5zARk6jVT_-d3cYaDksWBYH7dZ3qa1QT")
		.log(LogDetail.ALL)
	    .build();
	    
	}
	
	public static ResponseSpecification resSpec()
	{
	    return new ResponseSpecBuilder()
	    .expectContentType(ContentType.JSON)
	    .log(LogDetail.ALL)
	    .build();
	}
}
