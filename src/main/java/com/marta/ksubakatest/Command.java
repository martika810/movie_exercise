package com.marta.ksubakatest;

import java.util.List;

public interface Command<T> {
	
	List<T> execute(String urlQuery);
}
