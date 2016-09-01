package com.marta.ksubakatest.domainbean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestMovie {
	
	@Test
	public void testEquals(){
		Movie movie1 = new Movie.Builder("Now you see me").year("2016").imdbID("12").poster("poster").build();
		Movie movie2 = new Movie.Builder("Now you see me").year("2016").imdbID("12").poster("poster").build();
		Movie movie3 = new Movie.Builder("Now you see me").year("2016").imdbID("13").poster("poster").build();
		
		
		//reflesive 
		assertTrue(movie1.equals(movie1));
		
		//symmetry
		assertEquals(movie1.equals(movie2),movie2.equals(movie1));
		
		//transitive
		assertEquals(movie2.equals(movie3), movie1.equals(movie3));
		
	}
	
	@Test
	public void testHashing(){
		Movie movie1 = new Movie.Builder("Now you see me").year("2016").imdbID("12").poster("poster").build();
		Map<Movie,Movie> map = new HashMap<Movie,Movie>();
		map.put(movie1, movie1);
		assertEquals(movie1,map.get(movie1));
		
	}

}
