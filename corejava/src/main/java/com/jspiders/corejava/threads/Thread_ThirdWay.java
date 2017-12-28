package com.jspiders.corejava.threads;

import java.util.concurrent.Callable;

public class Thread_ThirdWay implements Callable<String>{

	public String call() throws Exception {
		String msg = "Thread Third Way";
		return msg;
	}
	
}//End of Class
