package com.marta.ksubakatest;

public class CommandLineArguments {
	public static final String DAPI = "-Dapi";
	public static final String DMOVIE = "-Dmovie";
	
	private String api = null;
	private String movie = null;
	
	private CommandLineArguments(){
		
	}
	
	public static CommandLineArguments createInstance(String args[]){
		CommandLineArguments arguments= new CommandLineArguments();
		for(String argument:args){
			if(argument.startsWith("-Dapi")){
				arguments.api = argument.split("=")[1];
			}
			if(argument.startsWith("-Dmovie")){
				arguments.movie =argument.split("=")[1];
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
