package com.marta.ksubakatest;

import java.util.List;

import com.marta.ksubakatest.domainbean.Movie;
import com.marta.ksubakatest.jsonbean.MovieList;

public class RetrieveMovieResponseNoWrapperCommand implements Command<Movie> {
	
	public List<Movie> execute(String urlQuery) {
		
		return MovieHttpQueryReceiver.getInstance().retrieveNoWrapper(urlQuery);
	}

}