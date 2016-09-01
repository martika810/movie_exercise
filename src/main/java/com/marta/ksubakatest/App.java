package com.marta.ksubakatest;

import java.util.List;

import com.marta.ksubakatest.commands.RetrieveMovieResponseNoWrapperCommand;
import com.marta.ksubakatest.commands.RetrieveMovieResponseWithWrapperCommand;
import com.marta.ksubakatest.domainbean.Movie;

/**
 * Hello world!
 *
 */
public class App {
	public static final String MOVIES_API_URL = "https://moviesapi.com/m.php";
	public static final String OMDB_API_URL = "http://www.omdbapi.com/";

	public static final String MOVIES_API = "moviesapi";
	public static final String OMDB_API = "omdbapi";

	public static void main(String[] args) {

		CommandLineArguments arguments = CommandLineArguments.createInstance(args);
		
		
		if (MOVIES_API.equals(arguments.getApi())) {
			RetrieveMovieResponseNoWrapperCommand retrieveMovieCommand = new RetrieveMovieResponseNoWrapperCommand();
			List<Movie> moviesFromMoviesApi = retrieveMovieCommand
					.execute(MOVIES_API_URL + "?y=&type=movie&r=json&t="
							+ arguments.getMovie());

			for (Movie movie : moviesFromMoviesApi) {
				System.out.println(movie);
			}
		} else {

			RetrieveMovieResponseWithWrapperCommand retrieveMovieWrapperCommand = new RetrieveMovieResponseWithWrapperCommand();
			List<Movie> moviesFromOmdbApi = retrieveMovieWrapperCommand
					.execute(OMDB_API_URL + "?r=json&s=" + arguments.getMovie());

			for (Movie movie : moviesFromOmdbApi) {
				System.out.println(movie);
			}
		}
	}
}
