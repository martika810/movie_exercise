package com.marta.ksubakatest.commands;

import java.util.List;

import com.marta.ksubakatest.domainbean.Movie;
import com.marta.ksubakatest.jsonbean.MovieList;
import com.marta.ksubakatest.receivers.MovieHttpQueryReceiver;

public class RetrieveMovieResponseNoWrapperCommand implements Command<Movie> {
	
	public List<Movie> execute(String urlQuery) {
		
		return MovieHttpQueryReceiver.getInstance().retrieveNoWrapper(urlQuery);
	}

}
