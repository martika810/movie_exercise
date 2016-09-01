package com.marta.ksubakatest.domainbean;

import java.util.Map;
import java.util.WeakHashMap;

import org.codehaus.jackson.annotate.JsonProperty;

import com.marta.ksubakatest.jsonbean.MovieMoviesApiBuilder;
import com.marta.ksubakatest.jsonbean.MovieOmdbApiBuilder;

public class Movie {
	
	private static final Map<Movie, Movie> cache = new WeakHashMap<Movie, Movie>();
	
	private final String title;
	private final String year;
	private final String imdbID;
	private final String type;
	private final String poster;
	
	
	public static class Builder{
		//Required
		private String title;
		//Optional
		private String year;
		private String imdbID;
		private String type;
		private String poster;
		
		public Builder(String title){
			this.title = title;
		}
		
		public Builder(MovieOmdbApiBuilder val){
			this.title=val.getTitle();
			this.year= val.getYear();
			this.imdbID = val.getImdbID();
			this.type = val.getType();
			this.poster = val.getPoster();
		}
		
		public Builder(MovieMoviesApiBuilder val){
			this.title=val.getTitle();
			this.year= val.getYear();
			this.imdbID = val.getId();
			this.type = val.getType();
			this.poster = val.getPoster();
		}
		public Builder year(String val){
			this.year = val;
			return this;
		}
		public Builder imdbID(String val){
			this.imdbID = val;
			return this;
		}
		public Builder type(String val){
			this.type = val;
			return this;
		}
		public Builder poster(String val){
			this.poster = val;
			return this;
		}
		public Movie build(){
			Movie newMovie = new Movie(this);
			if (cache.containsKey(newMovie)) {
				return cache.get(newMovie);
			}
			cache.put(newMovie, newMovie);
			return newMovie;
		}
		
	}
	
	private Movie(Builder builder){
		this.title=builder.title;
		this.year= builder.year;
		this.imdbID = builder.imdbID;
		this.type = builder.type;
		this.poster = builder.poster;
	}

	public String getTitle() {
		return title;
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

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", imdbID="
				+ imdbID + ", type=" + type + ", poster=" + poster + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imdbID == null) ? 0 : imdbID.hashCode());
		result = prime * result + ((poster == null) ? 0 : poster.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Movie)){
			return false;
		}
		Movie other = (Movie) obj;
		return  ((other.imdbID==null)?other.imdbID==imdbID:other.imdbID.equals(imdbID)) && 
				((other.title==null)?other.title==title:other.title.equals(title)) && 
				((other.poster==null)?other.poster==poster:other.poster.equals(poster)) &&
				((other.type==null)?other.type==type:other.type.equals(type)) && 
				((other.year==null)?other.year==year:other.year.equals(year));
				
			
	}	
	
	public String prettyText(){
		return new StringBuffer("Movie: ").append(title).append(" Year: ").append(year).toString();
	}
	

}
