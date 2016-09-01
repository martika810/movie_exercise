package com.marta.ksubakatest.receivers;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.marta.ksubakatest.domainbean.Movie;

public class TestMovieHttpQueryReceiver {
	private final static String SAMPLEWEB1_RESPONSE_WRAPPER = "http://www.omdbapi.com/?r=json&s=Now";
	private final static String SAMPLEWEB2_RESPONSE_WRAPPER = "https://moviesapi.com/m.php?y=&type=movie&r=json&t=Now";
	
	@Test
	public void testRetrieveWithWrapper(){
		List<Movie> movies = MovieHttpQueryReceiver.getInstance().retrieveWithWrapper(SAMPLEWEB1_RESPONSE_WRAPPER);
		assertTrue(movies!=null);
		assertTrue(!movies.isEmpty());
	}
	
	@Test
	public void testRetrieveWithWrapperIfNull(){
		List<Movie> movies = MovieHttpQueryReceiver.getInstance().retrieveWithWrapper(null);
		assertTrue(movies.isEmpty());
	}
	
	@Test
	public void testRetrieveNoWrapper(){
		List<Movie> movies = MovieHttpQueryReceiver.getInstance().retrieveNoWrapper(SAMPLEWEB2_RESPONSE_WRAPPER);
		assertTrue(movies!=null);
		assertTrue(!movies.isEmpty());
	}
	
	@Test
	public void testRetrieveNoWrapperIfNull(){
		List<Movie> movies = MovieHttpQueryReceiver.getInstance().retrieveNoWrapper(null);
		assertTrue(movies.isEmpty());
	}

}
