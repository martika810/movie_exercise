package com.marta.ksubakatest.jsonbean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieList {
	
	@JsonProperty("Search")
	private  List<MovieOmdbApiBuilder> search;

	public List<MovieOmdbApiBuilder> getSearch(){
		return this.search;
	}
	
	public void setSearch(List<MovieOmdbApiBuilder> val){
		this.search = val;
	}
	


}
