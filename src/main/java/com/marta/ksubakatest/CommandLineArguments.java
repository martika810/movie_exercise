package com.marta.ksubakatest;

public class CommandLineArguments {
	public static final String DAPI = "-Dapi";
	public static final String DMOVIE = "-Dmovie";
	public static final String SEPARATOR = "=";
	
	private String api = null;
	private String movie = null;
	
	private CommandLineArguments(){
		
	}
	
	public static CommandLineArguments createInstance(String args[]){
		CommandLineArguments arguments= new CommandLineArguments();
		for(String argument:args){
			if(argument.startsWith(DAPI)){
				arguments.api = argument.split(SEPARATOR)[1];
			}
			if(argument.startsWith(DMOVIE)){
				arguments.movie =argument.split(SEPARATOR)[1];
			}
		}
		return arguments;
		
	}

	public String getApi() {
		return api;
	}

	public String getMovie() {
		return movie;
	}
	

}
