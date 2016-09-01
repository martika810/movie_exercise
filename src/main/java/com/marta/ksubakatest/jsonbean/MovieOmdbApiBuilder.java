package com.marta.ksubakatest.jsonbean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;

import com.marta.ksubakatest.domainbean.Movie;


public class MovieOmdbApiBuilder {
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Year")
	private String year;
	
	@JsonProperty("imdbID")
	private String imdbID;
	
	
	
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("Poster")
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

	public String getImdbID() {
		return imdbID;
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
