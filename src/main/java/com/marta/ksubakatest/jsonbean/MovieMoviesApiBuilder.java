package com.marta.ksubakatest.jsonbean;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.marta.ksubakatest.domainbean.Movie;


public class MovieMoviesApiBuilder {
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("year")
	private String year;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("poster")
	private String poster;
	
	
	public String getTitle() {
		return title;
	}
	
	@JsonSetter("title")
	public void	 setTitle(String title) {
		this.title=title;
	}

	public String getYear() {
		return year;
	}

	
	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}

	public String getPoster() {
		return poster;
	}
	
	public Movie immutable(){
		return new Movie.Builder(this).build();
	}
	

}
