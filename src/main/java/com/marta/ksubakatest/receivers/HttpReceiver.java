package com.marta.ksubakatest.receivers;

import java.util.List;

public interface HttpReceiver<T> {
	
	List<T> retrieveWithWrapper(String query);
	List<T> retrieveNoWrapper(String query);

}
