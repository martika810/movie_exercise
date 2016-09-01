package com.marta.ksubakatest;

import java.util.List;

import com.marta.ksubakatest.commands.RetrieveMovieResponseNoWrapperCommand;
import com.marta.ksubakatest.commands.RetrieveMovieResponseWithWrapperCommand;
import com.marta.ksubakatest.domainbean.Movie;


public class App {
	public static final String MOVIES_API_URL = "https://moviesapi.com/m.php";
	public static final String OMDB_API_URL = "http://www.omdbapi.com/";

	public static final String MOVIES_API = "moviesapi";
	public static final String OMDB_API = "omdbapi";

	public static void main(String[] args) {

		String apiArg = System.getProperty("api");
		String movieArg = System.getProperty("movie");
		
		if (MOVIES_API.equals(apiArg)) {
			RetrieveMovieResponseNoWrapperCommand retrieveMovieCommand = new RetrieveMovieResponseNoWrapperCommand();
			List<Movie> moviesFromMoviesApi = retrieveMovieCommand
					.execute(MOVIES_API_URL + "?y=&type=movie&r=json&t="
							+ movieArg);
			printTitleBar();
			for (Movie movie : moviesFromMoviesApi) {
				System.out.println(movie);
				System.out.println("");
			}
		} else {

			RetrieveMovieResponseWithWrapperCommand retrieveMovieWrapperCommand = new RetrieveMovieResponseWithWrapperCommand();
			List<Movie> moviesFromOmdbApi = retrieveMovieWrapperCommand
					.execute(OMDB_API_URL + "?r=json&s=" + movieArg);

			printTitleBar();
			for (Movie movie : moviesFromOmdbApi) {
				System.out.println(movie);
				System.out.println("");
			}
		}
	}
	
	private static void printTitleBar(){
		System.out.println("--------------------------------------------------");
		System.out.println("              MOVIES                              ");
		System.out.println("--------------------------------------------------");
		System.out.println("");
	}
}
