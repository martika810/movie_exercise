package com.marta.ksubakatest.commands;

import java.util.List;

public interface Command<T> {
	
	List<T> execute(String urlQuery);
}
