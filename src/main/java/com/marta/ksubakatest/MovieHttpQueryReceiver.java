package com.marta.ksubakatest;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

import com.marta.ksubakatest.domainbean.Movie;
import com.marta.ksubakatest.jsonbean.MovieList;
import com.marta.ksubakatest.jsonbean.MovieMoviesApiBuilder;
import com.marta.ksubakatest.jsonbean.MovieOmdbApiBuilder;

public class MovieHttpQueryReceiver implements HttpReceiver<Movie> {
	
	private HttpClient httpClient;
	private ObjectMapper mapper;
	
	private static class SingletonHelper{
		private static MovieHttpQueryReceiver INSTANCE =  new MovieHttpQueryReceiver();
	}
	
	public static MovieHttpQueryReceiver getInstance(){
		return SingletonHelper.INSTANCE;
	}
	
	private MovieHttpQueryReceiver(){
		httpClient = HttpClientBuilder.create().build();
		mapper = new ObjectMapper();
	}

	public List<Movie> retrieveWithWrapper(String urlQuery) {
		
		List<Movie> listMovies = new ArrayList<Movie>();

		try {
			HttpGet request = new HttpGet(urlQuery);
			HttpResponse response = httpClient.execute(request);
			String jsonResponse = HttpUtility.convertToText(response);
			
			MovieList movies = mapper.readValue(jsonResponse, MovieList.class);
			for (MovieOmdbApiBuilder movie : movies.getSearch()) {
				listMovies.add(movie.immutable());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listMovies;
	}
	
	public List<Movie> retrieveNoWrapper(String urlQuery) {
		List<Movie> listMovies = new ArrayList<Movie>();
		
		try {
	
			HttpGet request = new HttpGet(urlQuery);
			HttpResponse response = httpClient.execute(request);
			String jsonResponse = HttpUtility.convertToText(response);

			List<MovieMoviesApiBuilder> moviesFromApi = mapper.readValue(jsonResponse,TypeFactory.defaultInstance().constructCollectionType(List.class,  
					MovieMoviesApiBuilder.class));
			
			for(MovieMoviesApiBuilder movie:moviesFromApi){
				listMovies.add(movie.immutable());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listMovies;
		
	}
	
	

}
